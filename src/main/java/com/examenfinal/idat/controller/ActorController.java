package com.examenfinal.idat.controller;

import com.examenfinal.idat.entity.Actor;
import com.examenfinal.idat.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actor")
    public List<Actor> getActor() {
        return actorService.getActor();
    }

    @GetMapping("/actor/{id}")
    public Actor getByid(@PathVariable Long id) {
        return actorService.getById(id);
    }


    @GetMapping("/actor/")
    public ResponseEntity<?> getCountBySex(@RequestParam String sex) {
        Map<String, Object> res = new HashMap<>();
        try {

            if (sex.equals("m")) {
                res.put("sexo_hombre", actorService.countBySex(sex));
            }

            if (sex.equals("f")) {
                res.put("sexo_mujer", actorService.countBySex(sex));
            }
        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/actor")
    public ResponseEntity<?> setActor(@RequestBody Actor actor) {
        Map<String, Object> res = new HashMap<>();
        try {
            actorService.setActor(actor);
            res.put("user ", actor.getName());
            res.put("msj ", " success");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/actor")
    public ResponseEntity<?> updateActor(@RequestBody Actor actor) {
        Map<String, Object> res = new HashMap<>();
        try {
            actorService.updateActor(actor);
            res.put("user ", actor.getName());
            res.put("msj ", " update");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/actor/{id}")
    public ResponseEntity<?> ChangeStatus(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        try {
            actorService.ChangeStatus(id);
            res.put("msj ", " Status update");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}

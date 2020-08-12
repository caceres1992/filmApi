package com.examenfinal.idat.controller;

import com.examenfinal.idat.entity.Director;
import com.examenfinal.idat.service.DirectorService;
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
public class DirectorController {


    @Autowired
    private DirectorService directorService;

    @GetMapping("/director")
    public List<Director> getDirector() {
        return directorService.getDirector();
    }

    @GetMapping("/director/{id}")
    public Director getByid(@PathVariable Long id) {
        return directorService.getByid(id);
    }

    @PostMapping("/director")
    public ResponseEntity<?> setDirector(@RequestBody Director director) {
        Map<String, Object> res = new HashMap<>();
        try {
            directorService.setDirector(director);
            res.put("director ", director.getName());
            res.put("msj ", " success");
        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/director")
    public ResponseEntity<?> updateDirector(@RequestBody Director director) {
        Map<String, Object> res = new HashMap<>();
        try {
            directorService.updateDirector(director);
            res.put("director ", director.getName());
            res.put("msj ", " update");
        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/director/{id}")
    public ResponseEntity<?> ChangeStatus(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        try {
            directorService.ChangeStatus(id);
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

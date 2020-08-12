package com.examenfinal.idat.controller;


import com.examenfinal.idat.entity.FilmActor;
import com.examenfinal.idat.service.FilmActorService;
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
public class FilmActorController {

    @Autowired
    private FilmActorService filmActorService;


    @GetMapping("/filmActor")
    public List<FilmActor> getFilmActor() {
        return filmActorService.getFilmActor();
    }


    @GetMapping("/filmActor/{id}")
    public FilmActor getByid(@PathVariable Long id) {
        return filmActorService.getById(id);
    }

    @GetMapping("/filmActor/oscarwinner")
    public List<FilmActor> findTop2ByOrderByOscarWinnerDesc() {
        return filmActorService.findTop2ByOrderByOscarWinnerDesc();
    }


    @PostMapping("/filmActor")
    public ResponseEntity<?> setFilmActor(@RequestBody FilmActor filmActor) {
        Map<String, Object> res = new HashMap<>();
        try {

            filmActorService.setFilmActor(filmActor);
            res.put("id ", filmActor.getId());
            res.put("msj ", " success");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/filmActor")
    public ResponseEntity<?> updateFilmActor(@RequestBody FilmActor filmActor) {
        Map<String, Object> res = new HashMap<>();
        try {
            filmActorService.filmActor1Update(filmActor);
            res.put("msj ", " update");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/filmActor/{id}")
    public ResponseEntity<?> ChangeStatus(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        try {
            filmActorService.ChangeStatus(id);
            res.put("msj ", " update Status");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}

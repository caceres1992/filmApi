package com.examenfinal.idat.controller;

import com.examenfinal.idat.entity.Actor;
import com.examenfinal.idat.entity.Film;
import com.examenfinal.idat.service.FilmService;
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
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public List<Film> getActor() {
        return filmService.getFilm();
    }

    @GetMapping("/film/{id}")
    public Film getById(@PathVariable Long id) {
        return filmService.getByid(id);
    }

    @GetMapping("/film/raiting")
    public List<Film> findTop5ByOrderByRaitingDesc() {
        return filmService.findTop5ByOrderByRaitingDesc();
    }


    @PostMapping("/film")
    public ResponseEntity<?> setFilm(@RequestBody Film film) {
        Map<String, Object> res = new HashMap<>();
        try {
            filmService.setFilms(film);
            res.put("film ", film.getTitle());
            res.put("msj ", " success");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/film")
    public ResponseEntity<?> updateFilm(@RequestBody Film film) {
        Map<String, Object> res = new HashMap<>();
        try {
            filmService.updateFilm(film);
            res.put("film ", film.getTitle());
            res.put("msj ", " update");

        } catch (DataAccessException e) {
            res.put("msj", " action invalid ");
            res.put("err", "sucede algo" + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping("/film/{id}")
    public ResponseEntity<?> ChangeStatus(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        try {
            filmService.ChangeStatus(id);
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

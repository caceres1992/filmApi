package com.examenfinal.idat.service;

import com.examenfinal.idat.entity.Film;
import com.examenfinal.idat.entity.FilmActor;
import com.examenfinal.idat.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    //listar
    public List<Film> getFilm() {
        return filmRepository.findAll();
    }

    //listar Por id
    public Film getByid(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    //listar Por Raiting
    public List<Film> findTop5ByOrderByRaitingDesc() {
        return filmRepository.findTop5ByOrderByRaitingDesc();
    }

    //agregar
    public Film setFilms(Film film) {
        Film newFilm = filmRepository.save(film);
        return newFilm;
    }


    //actualizar
    public Film updateFilm(Film film) {
        Film filmupdate = filmRepository.getOne(film.getId());
        filmupdate.setTitle(film.getTitle());
        filmupdate.setGenre(film.getGenre());
        filmupdate.setDirector(film.getDirector());
        filmupdate.setYear(film.getYear());
        filmupdate.setRaiting(film.getRaiting());
        return filmupdate;
    }


    //Change status
    public Film ChangeStatus(Long id) {
        Film filmStatus = filmRepository.getOne(id);
        filmStatus.setStatus(!filmStatus.isStatus());
        return filmRepository.save(filmStatus);
    }


}

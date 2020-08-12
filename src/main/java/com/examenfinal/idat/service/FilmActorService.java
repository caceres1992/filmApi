package com.examenfinal.idat.service;


import com.examenfinal.idat.entity.Actor;
import com.examenfinal.idat.entity.Director;
import com.examenfinal.idat.entity.Film;
import com.examenfinal.idat.entity.FilmActor;
import com.examenfinal.idat.repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class FilmActorService {
    @Autowired
    private FilmActorRepository filmActorRepository;

    //listar
    public List<FilmActor> getFilmActor() {
        return filmActorRepository.findAll();
    }


    //listar por id
    public FilmActor getById(Long id) {
        return filmActorRepository.findById(id).orElse(null);
    }


    public List<FilmActor> findTop2ByOrderByOscarWinnerDesc() {
        return filmActorRepository.findTop2ByOrderByOscarWinnerDesc();
    }


    //    agregar
    public FilmActor setFilmActor(FilmActor film) {

        FilmActor newFilmActor;
        newFilmActor = filmActorRepository.save(film);
        return newFilmActor;

    }


    //actualizar
    public FilmActor filmActor1Update(FilmActor filmActor) {
        FilmActor filmActorUpdate = filmActorRepository.getOne(filmActor.getId());
        filmActorUpdate.setActor(filmActor.getActor());
        filmActorUpdate.setFilm(filmActor.getFilm());
        filmActorUpdate.setOscarWinner(filmActor.getOscarWinner());
        return filmActorUpdate;
    }


    //Change status
    public FilmActor ChangeStatus(Long id) {
        FilmActor filmActorStatus = filmActorRepository.getOne(id);
        filmActorStatus.setStatus(!filmActorStatus.isStatus());
        return filmActorRepository.save(filmActorStatus);
    }


}

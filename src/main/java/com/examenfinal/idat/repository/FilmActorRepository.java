package com.examenfinal.idat.repository;

import com.examenfinal.idat.entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, Long> {

//    List<Film> findTop5ByOrderByRaitingDesc();
    List<FilmActor>findTop2ByOrderByOscarWinnerDesc();

}

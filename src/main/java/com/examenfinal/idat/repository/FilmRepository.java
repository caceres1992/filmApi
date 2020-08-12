package com.examenfinal.idat.repository;

import com.examenfinal.idat.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

    List<Film> findTop5ByOrderByRaitingDesc();


}

package com.examenfinal.idat.service;

import com.examenfinal.idat.entity.Genre;
import com.examenfinal.idat.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;


//    listar
    public List<Genre> getGenres(){return genreRepository.findAll();}


}

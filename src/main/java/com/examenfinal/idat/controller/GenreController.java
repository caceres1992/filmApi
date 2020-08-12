package com.examenfinal.idat.controller;

import com.examenfinal.idat.entity.Genre;
import com.examenfinal.idat.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    public List<Genre> getGenre() {
        return genreService.getGenres();
    }

}

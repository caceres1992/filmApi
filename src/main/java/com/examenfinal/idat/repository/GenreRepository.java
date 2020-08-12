package com.examenfinal.idat.repository;

import com.examenfinal.idat.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre,Long> {
}

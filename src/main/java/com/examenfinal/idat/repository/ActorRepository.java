package com.examenfinal.idat.repository;


import com.examenfinal.idat.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository  extends JpaRepository<Actor,Long> {

    int countBySex(String sexo);

}

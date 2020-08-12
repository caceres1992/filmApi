package com.examenfinal.idat.service;

import com.examenfinal.idat.entity.Actor;
import com.examenfinal.idat.entity.Director;
import com.examenfinal.idat.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    //listar
    public List<Director> getDirector() {
        return directorRepository.findAll();
    }

    //obtener por id
    public Director getByid(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    //agregar
    public Director setDirector(Director director) {
        Director newDirector = directorRepository.save(director);
        return newDirector;
    }

    //Change status
    public Director ChangeStatus(Long id) {
        Director directorStatus = directorRepository.getOne(id);
        directorStatus.setStatus(!directorStatus.isStatus());
        return directorRepository.save(directorStatus);
    }


    //actualizar
    public Director updateDirector(Director director) {

        Director directorUpdate = directorRepository.getOne(director.getId());
        directorUpdate.setName(director.getName());
        directorUpdate.setLastname(director.getLastname());
        return directorUpdate;
    }
}

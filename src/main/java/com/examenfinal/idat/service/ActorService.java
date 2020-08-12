package com.examenfinal.idat.service;

import com.examenfinal.idat.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examenfinal.idat.repository.ActorRepository;

import java.util.List;

@Service
@Transactional
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    //listar
    public List<Actor> getActor() {
        return actorRepository.findAll();
    }

    public Actor getById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    //guardar
    public Actor setActor(Actor actor) {
        Actor newActor = actorRepository.save(actor);
        return newActor;
    }

    //actualizar
    public Actor updateActor(Actor actor) {

        Actor actorupdate = actorRepository.getOne(actor.getId());
        actorupdate.setName(actor.getName());
        actorupdate.setLastname(actor.getLastname());
        actorupdate.setSex(actor.getSex());
        return actorupdate;
    }

//Change status
    public Actor ChangeStatus(Long id){
        Actor actorStatus = actorRepository.getOne(id);
        actorStatus.setStatus(!actorStatus.isStatus());
        return actorRepository.save(actorStatus);
    }



    public int countBySex(String sex) {

        return actorRepository.countBySex(sex);
    }



}

package com.examenfinal.idat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILM_ACTOR")
@Data

public class FilmActor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Actor actor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_film")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Film film;

    private int oscarWinner;

    private boolean status;

    @PrePersist
    void Persist() {
        status = true;
    }
    private static final long serialVersionUID = 1L;
}

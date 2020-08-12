package com.examenfinal.idat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Data
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genre")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Director director;

    private String year;
    private int raiting;

    private boolean status;

    @PrePersist
    void Persist() {
        status = true;
    }

    private static final long serialVersionUID = 1L;
}

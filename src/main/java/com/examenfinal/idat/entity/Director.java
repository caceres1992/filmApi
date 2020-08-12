package com.examenfinal.idat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DIRECTOR")
@Data
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private  String name;
    private  String lastname;
    private static final long serialVersionUID = 1L;

    private boolean status;

    @PrePersist
    void Persist() {
        status = true;
    }
}

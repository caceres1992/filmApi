package com.examenfinal.idat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ACTOR")
@Data
public class Actor implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String lastname;
    private String sex;

     boolean status;

    @PrePersist
    void Persist() {
        status = true;
    }
}

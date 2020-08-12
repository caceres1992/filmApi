package com.examenfinal.idat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table (name = "GENRE")
@Data
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private   String name;
    private boolean status;

    @PrePersist
    void Persist() {
        status = true;
    }

}

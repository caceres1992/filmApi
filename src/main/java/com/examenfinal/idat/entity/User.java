package com.examenfinal.idat.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private  String name;
    private  String lastname;
    private String username;
    private String password;




}

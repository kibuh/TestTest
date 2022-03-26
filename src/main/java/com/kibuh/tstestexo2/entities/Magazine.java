package com.kibuh.tstestexo2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Magazine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false)
    private String nom;
}

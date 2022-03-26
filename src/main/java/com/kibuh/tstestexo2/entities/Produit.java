package com.kibuh.tstestexo2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomProduit;

    @Column(nullable = false)
    private Double prix;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "produits")
    private Set<Magazine> magazines;


}

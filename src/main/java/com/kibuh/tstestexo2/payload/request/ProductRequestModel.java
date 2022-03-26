package com.kibuh.tstestexo2.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestModel implements Serializable {

    private String nomProduit;
    private Double prix;
}

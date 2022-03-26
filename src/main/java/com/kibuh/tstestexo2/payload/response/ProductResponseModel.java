package com.kibuh.tstestexo2.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseModel implements Serializable {

    private long id;
    private String nomProduit;
    private Double prix;
}

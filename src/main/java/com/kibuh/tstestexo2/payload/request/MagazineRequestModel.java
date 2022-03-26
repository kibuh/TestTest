package com.kibuh.tstestexo2.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MagazineRequestModel implements Serializable {

    private String nom;
}

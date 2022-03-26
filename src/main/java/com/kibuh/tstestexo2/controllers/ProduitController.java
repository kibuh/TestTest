package com.kibuh.tstestexo2.controllers;

import com.kibuh.tstestexo2.payload.request.ProductRequestModel;
import com.kibuh.tstestexo2.payload.response.ProductResponseModel;
import com.kibuh.tstestexo2.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @PostMapping
    public ProductResponseModel createProduit(@RequestBody ProductRequestModel requestModel){

        return produitService.createProduit(requestModel);
    }

    @GetMapping
    public List<ProductResponseModel> getProduits(@RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "5") int limit){
        return produitService.getproduits(page, limit);
    }
}

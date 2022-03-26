package com.kibuh.tstestexo2.services;

import com.kibuh.tstestexo2.entities.Produit;
import com.kibuh.tstestexo2.payload.request.ProductRequestModel;
import com.kibuh.tstestexo2.payload.response.ProductResponseModel;
import com.kibuh.tstestexo2.rrepositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;


    public ProductResponseModel createProduit(ProductRequestModel productRequestModel){

        Produit produit = modelMapper.map(productRequestModel, Produit.class);
        Produit newProduit = productRepository.save(produit);

        return modelMapper.map(newProduit,ProductResponseModel.class);
    }

    public List<ProductResponseModel> getproduits(int page, int limit){
        Pageable pageable = PageRequest.of(page, limit);
        List<ProductResponseModel> productResponseModels = new ArrayList<>();
        Page<Produit> produitList = productRepository.findAll(pageable);


        produitList.forEach(produit -> productResponseModels.add(modelMapper.map(produit, ProductResponseModel.class)));

        return productResponseModels;
    }


}

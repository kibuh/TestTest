package com.kibuh.tstestexo2.services;

import com.kibuh.tstestexo2.entities.Magazine;
import com.kibuh.tstestexo2.entities.Produit;
import com.kibuh.tstestexo2.payload.request.MagazineRequestModel;
import com.kibuh.tstestexo2.payload.response.MagazineResponseModel;
import com.kibuh.tstestexo2.payload.response.ProductResponseModel;
import com.kibuh.tstestexo2.rrepositories.MagazinRepository;
import com.kibuh.tstestexo2.rrepositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MagazineService {

    @Autowired
    MagazinRepository magazinRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;


    public MagazineResponseModel createMagazine(MagazineRequestModel requestModel){
        Magazine magazine = modelMapper.map(requestModel, Magazine.class);

        return modelMapper.map(magazinRepository.save(magazine),MagazineResponseModel.class);

    }

    public List<MagazineResponseModel> getAllMagazine(int page, int limit){
        Pageable pageable = PageRequest.of(page, limit);

        List<MagazineResponseModel> magazineResponseModels = new ArrayList<>();
        Page<Magazine> magazines = magazinRepository.findAll(pageable);


        magazines.forEach(magazine -> magazineResponseModels.add(modelMapper.map(magazine, MagazineResponseModel.class)));

        return magazineResponseModels;

    }

    public ProductResponseModel addproduct(long magazine_id, Produit produit){

        return magazinRepository.findById(magazine_id).map(magazine ->{

            Optional<Produit> exitProduct = productRepository.findById(produit.getId());

            if(exitProduct.isPresent()){

                magazine.getProduits().add(exitProduct.get());

                magazinRepository.save(magazine);

                return modelMapper.map(exitProduct,ProductResponseModel.class);
            }

            Produit produit1 = productRepository.save(produit);

            magazine.getProduits().add(produit1);

            return modelMapper.map(produit1,ProductResponseModel.class);

        }).orElseThrow(() -> new RuntimeException("Magazine with id " +magazine_id +"  does not exist"));

    }

    public ResponseEntity  removeProduct(long magazine_id, Produit produit){

       return magazinRepository.findById(magazine_id).map(magazine -> {
           ResponseEntity<Map<String, String>> mapResponseEntity = productRepository.findById(produit.getId()).map(produit1 -> {

               magazine.getProduits().remove(produit1);

               magazinRepository.save(magazine);

               Map<String, String> response = new HashMap<>();

               response.put("status", "Produit removed");

               return ResponseEntity.ok(response);


           }).orElseThrow(() -> new RuntimeException("Produit with id " + produit.getId() + "  does not exist"));
           return mapResponseEntity;

       }).orElseThrow(() -> new RuntimeException("Magazine with id " +magazine_id +"  does not exist"));

    }
}

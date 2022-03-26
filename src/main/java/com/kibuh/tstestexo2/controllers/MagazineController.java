package com.kibuh.tstestexo2.controllers;

import com.kibuh.tstestexo2.payload.request.MagazineRequestModel;
import com.kibuh.tstestexo2.payload.request.ProductRequestModel;
import com.kibuh.tstestexo2.payload.response.MagazineResponseModel;
import com.kibuh.tstestexo2.payload.response.ProductResponseModel;
import com.kibuh.tstestexo2.services.MagazineService;
import com.kibuh.tstestexo2.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magazines")
public class MagazineController {

    @Autowired
    MagazineService magazineService;

    @PostMapping
    public MagazineResponseModel createMagazine(@RequestBody MagazineRequestModel magazineRequestModel){

        return magazineService.createMagazine(magazineRequestModel);
    }

    @GetMapping
    public List<MagazineResponseModel> getMagazines(@RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "5") int limit){
        return magazineService.getAllMagazine(page, limit);
    }
}

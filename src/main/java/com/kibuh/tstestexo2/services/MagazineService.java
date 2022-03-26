package com.kibuh.tstestexo2.services;

import com.kibuh.tstestexo2.entities.Magazine;
import com.kibuh.tstestexo2.payload.request.MagazineRequestModel;
import com.kibuh.tstestexo2.payload.response.MagazineResponseModel;
import com.kibuh.tstestexo2.rrepositories.MagazinRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagazineService {

    @Autowired
    MagazinRepository magazinRepository;

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
}

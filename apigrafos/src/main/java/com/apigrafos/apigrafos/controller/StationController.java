package com.apigrafos.apigrafos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigrafos.apigrafos.domain.Station;
import com.apigrafos.apigrafos.dto.StationDTO;
import com.apigrafos.apigrafos.service.StationService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/station")
public class StationController {
    
    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<Station>> getAllStation() {
        List<Station> list = stationService.getAllStation();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Station> addNewStation(@RequestBody @Valid StationDTO data) {
        return ResponseEntity.ok(stationService.addNewStation(data));
    }

}   
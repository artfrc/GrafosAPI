package com.apigrafos.apigrafos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigrafos.apigrafos.domain.Station;
import com.apigrafos.apigrafos.service.StationService;

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

}   
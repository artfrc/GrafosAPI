package com.apigrafos.apigrafos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apigrafos.apigrafos.domain.Station;
import com.apigrafos.apigrafos.repository.StationRepository;

@Service
public class StationService {
    
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStation() {
        return stationRepository.findAll();
    }

}

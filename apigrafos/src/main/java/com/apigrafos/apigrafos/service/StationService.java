package com.apigrafos.apigrafos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apigrafos.apigrafos.domain.Station;
import com.apigrafos.apigrafos.dto.StationDTO;
import com.apigrafos.apigrafos.repository.StationRepository;

@Service
public class StationService {
    
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStation() {
        return stationRepository.findAll();
    }

    public Station addNewStation(StationDTO data) {
        Station newStation = new Station(data);
        stationRepository.save(newStation);
        return newStation;
    }

    public Station deleteStation(Long id) {
        Station station = stationRepository.findById(id).get();
        stationRepository.delete(station);
        return station;
    }

}

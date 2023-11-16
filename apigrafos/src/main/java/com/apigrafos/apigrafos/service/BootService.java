package com.apigrafos.apigrafos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.apigrafos.apigrafos.domain.Route;
import com.apigrafos.apigrafos.domain.Station;
import com.apigrafos.apigrafos.dto.RouteDTO;
import com.apigrafos.apigrafos.dto.StationDTO;
import com.apigrafos.apigrafos.repository.RouteRepository;
import com.apigrafos.apigrafos.repository.StationRepository;

@Service
public class BootService {
    
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        routeRepository.deleteAll();
        stationRepository.deleteAll();

        stationRepository.save(new Station(new StationDTO("E1 - Cesario Alvim")));
        stationRepository.save(new Station(new StationDTO("E2 - Pereiras")));
        stationRepository.save(new Station(new StationDTO("E3 - Sesc")));
        stationRepository.save(new Station(new StationDTO("E4 - Shopping")));
        stationRepository.save(new Station(new StationDTO("E5 - Prefeitura")));
        stationRepository.save(new Station(new StationDTO("E6 - UFU")));

        stationRepository.save(new Station(new StationDTO("E? - Avenida Alexandre Ribeiro Guimarães")));
        stationRepository.save(new Station(new StationDTO("E? - Rua Joaquim Cordeiro")));
        stationRepository.save(new Station(new StationDTO("E? - Avenida Nicodemos Alves dos Santos")));

        routeRepository.save(new Route(new RouteDTO("E1 - Cesario Alvim", "E2 - Pereiras",  442.21f)));
        routeRepository.save(new Route(new RouteDTO("E2 - Pereiras", "E3 - Sesc",  367.85f)));
        routeRepository.save(new Route(new RouteDTO("E3 - Sesc", "E4 - Shopping",  554.28f)));
        routeRepository.save(new Route(new RouteDTO("E4 - Shopping", "E5 - Prefeitura",  319.11f)));
        routeRepository.save(new Route(new RouteDTO("E5 - Prefeitura", "E6 - UFU",  433.44f)));

        routeRepository.save(new Route(new RouteDTO("E3 - Sesc", "E? - Avenida Alexandre Ribeiro Guimarães",  579.07f)));

        routeRepository.save(new Route(new RouteDTO("E1 - Cesario Alvim", "E? - Rua Joaquim Cordeiro",  432.81f)));
        routeRepository.save(new Route(new RouteDTO("E? - Rua Joaquim Cordeiro", "E? - Avenida Nicodemos Alves dos Santos",  589.12f)));
        routeRepository.save(new Route(new RouteDTO("E? - Avenida Nicodemos Alves dos Santos", "E6 - UFU",  468.02f)));

        for(int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

}

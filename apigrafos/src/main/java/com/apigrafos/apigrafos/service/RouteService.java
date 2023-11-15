package com.apigrafos.apigrafos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apigrafos.apigrafos.domain.Route;
import com.apigrafos.apigrafos.dto.RouteDTO;
import com.apigrafos.apigrafos.repository.RouteRepository;
import com.apigrafos.apigrafos.repository.StationRepository;


@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route addRoute(RouteDTO data) throws Exception {

        if(stationRepository.findByName(data.source()).isEmpty()) {
            throw new Exception("Source does not exist!");
        }

        if(stationRepository.findByName(data.destiny()).isEmpty()) {
            throw new Exception("Destiny does not exist!");
        }

        List<Route> list = routeRepository.findBySource(data.source());

        for (Route route : list) {
            if(route.getDestiny().equals(data.destiny())) {
                throw new Exception("Route already exists!");
            }
        }

        Route route = new Route(data);
        routeRepository.save(route);
        return route;
    }
    
}

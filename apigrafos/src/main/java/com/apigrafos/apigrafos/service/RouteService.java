package com.apigrafos.apigrafos.service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apigrafos.apigrafos.domain.Route;
import com.apigrafos.apigrafos.domain.Station;
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

    public AbstractMap.SimpleEntry<List<String>, Float> djikstra(String source, String destiny) {
        
        List<Station> allStations = stationRepository.findAll();
        HashMap<String, Float> mp = new HashMap<>();
        HashMap<String, String> path = new HashMap<>();

        path.put(source, source);
        
        for (Station station : allStations) {
            mp.put(station.getName(), -1f);
        }

        PriorityQueue<AbstractMap.SimpleEntry<Float, String>> pq = new PriorityQueue<>((b, a) -> Float.compare(b.getKey(), a.getKey()));

        pq.add(new AbstractMap.SimpleEntry<>(0f, source));

        while (!pq.isEmpty()) {
            AbstractMap.SimpleEntry<Float, String> aux = pq.poll();
    
            Float distance = aux.getKey();
            String station = aux.getValue();
    
            System.out.println(">> Station: " + station);
    
            if (mp.get(station) == -1f) {
                mp.put(station, distance);
    
                if (station.equals(destiny)) {
                    List<String> list = shortestPath(path, destiny, source);
                    return new AbstractMap.SimpleEntry<>(list, mp.get(destiny));
                }
    
                // pegar os vizinhos de station
                List<Route> routesWithSourceStation = routeRepository.findBySource(station);
    
                for (Route route : routesWithSourceStation) {
                    String neighbor = route.getDestiny();
                    Float distanceToNeigh = route.getDistance();
    
                    if (mp.get(route.getDestiny()) == -1f) {
                        pq.add(new AbstractMap.SimpleEntry<>(distance + distanceToNeigh, neighbor));
                    }
    
                    if ((path.get(neighbor) == null) || (mp.get(neighbor) > distance + distanceToNeigh)) {
                        path.put(neighbor, station);
                    }
                }
            }
        }
    
        // Adicione um retorno adequado caso a condição de destino nunca seja alcançada
        return new AbstractMap.SimpleEntry<>(new ArrayList<>(), -1f);

    }

    public List<String> shortestPath(HashMap<String, String> pathHash, String start, String end) {
        List<String> path = new ArrayList<>();

        String current = start;

        do {
            path.add(current);
            current = pathHash.get(current);
        } while (current != null && !current.equals(end));

        if (current != null) {
            path.add(end);
            Collections.reverse(path);
        } else {
            path.clear(); // Limpar a lista se o caminho não for encontrado
        }

        return path;
    }
    
}

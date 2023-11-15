package com.apigrafos.apigrafos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apigrafos.apigrafos.domain.Route;
import java.util.List;


public interface RouteRepository extends JpaRepository<Route,Long> {
    
    List<Route> findBySource(String source);
    List<Route> findByDestiny(String destiny);

}

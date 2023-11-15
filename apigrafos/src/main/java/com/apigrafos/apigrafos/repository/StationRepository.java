package com.apigrafos.apigrafos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apigrafos.apigrafos.domain.Station;
import java.util.List;


public interface StationRepository extends JpaRepository<Station,Long> {

    List<Station> findByName(String name);
    
}

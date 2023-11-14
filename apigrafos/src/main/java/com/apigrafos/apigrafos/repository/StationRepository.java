package com.apigrafos.apigrafos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apigrafos.apigrafos.domain.Station;

public interface StationRepository extends JpaRepository<Station,Long> {
    
}

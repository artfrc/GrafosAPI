package com.apigrafos.apigrafos.domain;

import com.apigrafos.apigrafos.dto.StationDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "stations")
@Table(name = "stations")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float heuristic;


    public Float getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Float heuristic) {
        this.heuristic = heuristic;
    }

    public Station(StationDTO data) {
        this.name = data.name();
        this.heuristic = data.heuristic();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

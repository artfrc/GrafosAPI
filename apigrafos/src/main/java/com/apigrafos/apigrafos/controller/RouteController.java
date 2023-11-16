package com.apigrafos.apigrafos.controller;

import java.util.AbstractMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigrafos.apigrafos.domain.Route;
import com.apigrafos.apigrafos.dto.RouteDTO;
import com.apigrafos.apigrafos.service.RouteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/route")
public class RouteController {
    
    @Autowired
    private RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Route> addRoute(@RequestBody @Valid RouteDTO data) throws Exception {
        return ResponseEntity.ok(routeService.addRoute(data));
    }

    @GetMapping("/djikstra/{source}/{destiny}")
    public ResponseEntity<AbstractMap.SimpleEntry<List<String>, Float>> djikstra(@PathVariable String source, @PathVariable String destiny) {
        return ResponseEntity.ok(routeService.djikstra(source, destiny));
    }

}

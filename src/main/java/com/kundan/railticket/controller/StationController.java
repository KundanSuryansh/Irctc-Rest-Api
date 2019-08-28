package com.kundan.railticket.controller;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    StationRepository stationRepository;
    @GetMapping("/stations")
    List<Station> getAllStations()
    {
        return stationRepository.findAll();
    }
    @PostMapping("/stations")
    List<Station> saveAllStations(List<Station> stationList)
    {
        for (Station station:stationList)
        {
            stationRepository.save(station);
        }
        return getAllStations();
    }
    @DeleteMapping("/station/{id}")
    List<Station> deleteStation(@PathVariable long id)
    {
        stationRepository.deleteById(id);
        return getAllStations();
    }
    @PutMapping("/stations")
    List<Station> updateStation(@RequestBody List<Station> stationList)
    {
        for(Station station : stationList)
        {
            stationRepository.updateStationById(station.getStationId(),station.getName());
        }
        return getAllStations();
    }
}

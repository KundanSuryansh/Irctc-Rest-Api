package com.kundan.railticket.controller;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.TrainStationRepository;
import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StationController {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    TrainStationRepository trainStationRepository;

    @Autowired
    TrainRepository trainRepository;

    @GetMapping("/user/stations")
   public List<Station> getAllStations()
    {
        return stationRepository.findAll();
    }
    
    @PostMapping("/admin/stations")
    public List<Station> saveAllStations(List<Station> stationList)
    {
        for (Station station:stationList)
        {
            stationRepository.save(station);
        }
        return getAllStations();
    }

    @DeleteMapping("/admin/station/{id}")
    public List<Station> deleteStation(@PathVariable long id)
    {
        stationRepository.deleteById(id);
        return getAllStations();
    }

    @PutMapping("/admin/stations")
   public  List<Station> updateStation(@RequestBody List<Station> stationList)
    {
        for(Station station : stationList)
        {
            stationRepository.updateStationById(station.getStationId(),station.getName());
        }
        return getAllStations();
    }


    @GetMapping("/train-station/{trainNo}")
   public  Map<String,String> getAllStationOfTrainWithArrivalTime(@PathVariable int trainNo)
    {
        Map<String,String> map=new HashMap<>();

        List<TrainStation> trainStations=trainStationRepository.getTrainStationByTrain(trainRepository.getTrainsByTrainNo(trainNo));
        for(TrainStation trainStation:trainStations)
        {
            map.put(trainStation.getArrivalTime().toString(),trainStation.getStations().getName());
        }
        return map;
    }
}

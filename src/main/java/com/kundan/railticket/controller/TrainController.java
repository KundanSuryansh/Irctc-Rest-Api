package com.kundan.railticket.controller;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.TrainStationRepository;
import com.kundan.railticket.entity.TrainStation;
import com.kundan.railticket.entity.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/train-details")
public class TrainController {

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainStationRepository trainStationRepository;

    @Autowired
    StationRepository stationRepository;

    @GetMapping("/trains")
    public List<Trains> getAllTrains()
    {
        return trainRepository.findAll();

    }

    @GetMapping("/train/{trainNo}")
    public Optional<Trains> getTrainById(@PathVariable int trainNo)
    {
    return trainRepository.findById(trainNo);
    }


    @GetMapping("/train/{trainNo}/train-stations")
    public List<TrainStation> getStationsOfTrain(@PathVariable int trainNo)
    {
        return trainStationRepository.getTrainStationByTrain(trainRepository.getTrainsByTrainNo(trainNo));
    }

    @PostMapping("/train")
    public List<Trains> saveTrain(@RequestBody List<Trains> trainsList)
    {
        for(Trains trains:trainsList) {
            trainRepository.save(trains);
        }
        return getAllTrains();
    }

    @DeleteMapping("/train/{trainNo}")
    public void deleteTrainById(@PathVariable int trainNo)
    {
        trainRepository.deleteById(trainNo);
    }
    @PutMapping("/train/{trainNo}")
    public List<Trains> updateTrainById(@PathVariable int trainNo, @RequestBody Trains updateTrains)
    {
        trainRepository.updateTrainById(trainNo,updateTrains.getName(),updateTrains.getTotalSeats());
        return trainRepository.findAll();
    }


}

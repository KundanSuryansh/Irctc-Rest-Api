package com.kundan.railticket.controller;

import com.kundan.railticket.dao.TrainRepository;
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

    @PostMapping("/train")
    public Optional<Trains> saveTrain(@RequestBody Trains trains)
    {
        trainRepository.save(trains);
        return getTrainById(trains.getTrainNo());
    }

    @DeleteMapping("/train/{trainNo}")
    public List<Trains> DeleteTrainById(@PathVariable int trainNo)
    {
        trainRepository.deleteById(trainNo);
        return trainRepository.findAll();
    }
    @PutMapping("/train/{trainNo}")
    public List<Trains> UpdateTrainById(@PathVariable int trainNo, @RequestBody Trains updatetrains)
    {
        Optional<Trains> trains = trainRepository.findById(trainNo);

        trains.get().setName(updatetrains.getName());
        trains.get().setTotalSeats(updatetrains.getTotalSeats());
        trainRepository.save(trains.get());
        return trainRepository.findAll();
    }
}

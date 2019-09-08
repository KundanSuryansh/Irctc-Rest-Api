package com.kundan.railticket.controller;

import com.kundan.railticket.dto.request.RequestTrainsDTO;
import com.kundan.railticket.dto.response.ResponseTrainsDTO;
import com.kundan.railticket.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("/trains")
    public List<ResponseTrainsDTO> getAllTrains()
    {
        return trainService.getAllTrains();

    }
    @GetMapping("/train/{trainNo}")
    public ResponseTrainsDTO getTrainById(@PathVariable int trainNo)
    {
    return trainService.getTrainById(trainNo);
    }
    @PostMapping("/admin/train")
    public String saveTrain(@RequestBody List<RequestTrainsDTO> trainsList)
    {
        return trainService.save(trainsList);
    }

    @DeleteMapping("/admin/train/{trainNo}")
    public String deleteTrainById(@PathVariable int trainNo)
    {
        return trainService.deleteById(trainNo);
    }
    @PutMapping("/admin/train")
    public String updateTrainById( @RequestBody RequestTrainsDTO requestTrainsDTO)
    {
        return trainService.updateTrain(requestTrainsDTO);
    }

}

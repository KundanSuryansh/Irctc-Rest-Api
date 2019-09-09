package com.kundan.railticket.controller;

import com.kundan.railticket.dto.request.RequestTrainsDTO;
import com.kundan.railticket.dto.response.ResponseTrainsDTO;
import com.kundan.railticket.service.TrainService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
public class TrainController {

    @Autowired
    TrainService trainService;

    @ApiOperation(value = "To get the details of all trains")
    @GetMapping("/user/trains")
    public List<ResponseTrainsDTO> getAllTrains()
    {
        return trainService.getAllTrains();
    }

    @ApiOperation(value = "To get the details of train on particular date")
    @GetMapping("/user/train/{trainNo}/{date}")
    public ResponseTrainsDTO getTrainDetailsByDate(@PathVariable int trainNo,@PathVariable Date date)
    {
        return  trainService.getTrainDetailsByDate(trainNo,date);
    }


    @ApiOperation(value = "To get the details of train by train number")
    @GetMapping("/user/train/{trainNo}")
    public ResponseTrainsDTO getTrainById(@PathVariable int trainNo)
    {
    return trainService.getTrainById(trainNo);
    }


    @ApiOperation(value = "To save any train,can be done by admin only")
    @PostMapping("/admin/train")
    public String saveTrain(@RequestBody List<RequestTrainsDTO> trainsList)
    {
        return trainService.save(trainsList);
    }

    @ApiOperation(value = "To delete any train by giving train number,can be done by admin only")
    @DeleteMapping("/admin/train/{trainNo}")
    public String deleteTrainById(@PathVariable int trainNo)
    {
        return trainService.deleteById(trainNo);
    }


    @ApiOperation(value = "To update any train by giving train number,can be done by admin only")
    @PutMapping("/admin/train")
    public String updateTrainById( @RequestBody RequestTrainsDTO requestTrainsDTO)
    {
        return trainService.updateTrain(requestTrainsDTO);
    }

}

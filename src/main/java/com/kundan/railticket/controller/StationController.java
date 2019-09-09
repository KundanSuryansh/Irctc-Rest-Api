package com.kundan.railticket.controller;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.TrainStationRepository;
import com.kundan.railticket.dto.request.RequestStationDTO;
import com.kundan.railticket.dto.response.ResponseStationDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import com.kundan.railticket.service.StationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StationController {

    @Autowired
    StationService stationService;

    @Autowired
    TrainStationRepository trainStationRepository;

    @Autowired
    TrainRepository trainRepository;

    @ApiOperation(value = "To get the details of all stations")
    @GetMapping("/user/stations")
   public List<ResponseStationDTO> getAllStations()
    {
        return stationService.getAllStation();
    }

    @ApiOperation(value = "To save the stations,can be done by admin only")
    @PostMapping("/admin/stations")
    public String saveAllStations(List<RequestStationDTO> requestStationDTOS)
    {
      return   stationService.save(requestStationDTOS);
    }

    @ApiOperation(value = "To delete the station,can be done by admin only")
    @DeleteMapping("/admin/station/{id}")
    public String deleteStation(@PathVariable long id)
    {
       return stationService.deleteStationById(id);
    }

    @ApiOperation(value = "To update the station,can be done by admin only")
    @PutMapping("/admin/stations/{id}")
   public  String updateStation(@PathVariable long id,@RequestBody RequestStationDTO requestStationDTO)
    {
            return stationService.updateStationById(id,requestStationDTO);
    }


    @ApiOperation(value = "To delete the detail of train passing through different station with arrival time")
    @GetMapping("/user/train-station/{trainNo}")
   public  Map<String,String> getAllStationOfTrainWithArrivalTime(@PathVariable int trainNo)
    {
        return stationService.getAllStationOfTrainWithArrivalTime(trainNo);
    }
}

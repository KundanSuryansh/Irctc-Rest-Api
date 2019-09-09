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

    @GetMapping("/user/stations")
   public List<ResponseStationDTO> getAllStations()
    {
        return stationService.getAllStation();
    }
    
    @PostMapping("/admin/stations")
    public String saveAllStations(List<RequestStationDTO> requestStationDTOS)
    {
      return   stationService.save(requestStationDTOS);
    }

    @DeleteMapping("/admin/station/{id}")
    public String deleteStation(@PathVariable long id)
    {
       return stationService.deleteStationById(id);
    }

    @PutMapping("/admin/stations/{id}")
   public  String updateStation(@PathVariable long id,@RequestBody RequestStationDTO requestStationDTO)
    {
            return stationService.updateStationById(id,requestStationDTO);
    }


    @GetMapping("/train-station/{trainNo}")
   public  Map<String,String> getAllStationOfTrainWithArrivalTime(@PathVariable int trainNo)
    {
        return stationService.getAllStationOfTrainWithArrivalTime(trainNo);
    }
}

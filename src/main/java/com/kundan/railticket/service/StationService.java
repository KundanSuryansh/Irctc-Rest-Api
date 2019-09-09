package com.kundan.railticket.service;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.TrainStationRepository;
import com.kundan.railticket.dto.request.RequestStationDTO;
import com.kundan.railticket.dto.response.ResponseStationDTO;
import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainStationRepository trainStationRepository;

    public String save(List<RequestStationDTO> requestStationDTOS) {

        for (RequestStationDTO requestStationDTO:requestStationDTOS) {

            Station station = new Station(requestStationDTO.getName());

            stationRepository.save(station);
        }
        return "All stations got saved!";
    }

    public List<ResponseStationDTO> getAllStation() {
        List<ResponseStationDTO> responseStationDTOS=new ArrayList<>();
        for(Station station:stationRepository.findAll())
        {
            ResponseStationDTO responseStationDTO=new ResponseStationDTO(station.getStationId(),station.getName());
            responseStationDTOS.add(responseStationDTO);
        }
        return responseStationDTOS;
    }

    public String deleteStationById(long id) {
        Optional<Station> station=stationRepository.findById(id);
        if(station.isPresent()) {
            stationRepository.deleteById(id);
            return "deleted successfully!";
        }
        return "No id found :[ !";
    }

    public String updateStationById(long id, RequestStationDTO requestStationDTO) {
        Optional<Station> station=stationRepository.findById(id);
        if(station.isPresent()) {
            stationRepository.updateStationById(id,requestStationDTO.getName());
            return "updated Successfully! ";
        }
       return  "No id found :[ !";
    }

    public Map<String, String> getAllStationOfTrainWithArrivalTime(int trainNo) {

        Map<String,String> map=new HashMap<>();

        List<TrainStation> trainStations=trainStationRepository.getTrainStationByTrain(trainRepository.getTrainsByTrainNo(trainNo));
        for(TrainStation trainStation:trainStations)
        {
            map.put(trainStation.getArrivalTime().toString(),trainStation.getStations().getName());
        }
        return map;
    }

}

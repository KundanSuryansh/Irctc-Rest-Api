package com.kundan.railticket.service;

import com.kundan.railticket.dao.StationRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.TrainStationRepository;
import com.kundan.railticket.dto.request.RequestTrainsDTO;
import com.kundan.railticket.dto.response.ResponseTrainsDTO;
import com.kundan.railticket.entity.TrainStation;
import com.kundan.railticket.entity.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TrainStationRepository trainStationRepository;

    @Autowired
    StationRepository stationRepository;

    public List<ResponseTrainsDTO> getAllTrains()
    {
        List<Trains> trainsList=trainRepository.findAll();
        List<ResponseTrainsDTO> responseTrainsDTOList=new ArrayList<>();
        for(Trains trains:trainsList)
        {
            List<TrainStation> trainStations=trainStationRepository.getTrainStationByTrain(trains);
            List<String> stations=new ArrayList<>();
            for(TrainStation trainStation:trainStations)
            {
                stations.add(trainStation.getStations().getName());
            }
            ResponseTrainsDTO responseTrainsDTO=new ResponseTrainsDTO(trains.getTrainNo(),trains.getName(),trains.getTotalSeats(),stations);
            responseTrainsDTOList.add(responseTrainsDTO);
        }
        return responseTrainsDTOList;
    }
    public ResponseTrainsDTO getTrainById(int trainNo)
    {
        Trains trains=trainRepository.getTrainsByTrainNo(trainNo);
        List<TrainStation> trainStations=trainStationRepository.getTrainStationByTrain(trains);
        List<String> stations=new ArrayList<>();
        for(TrainStation trainStation:trainStations)
        {
            stations.add(trainStation.getStations().getName());
        }
        return  new ResponseTrainsDTO(trains.getTrainNo(),trains.getName(),trains.getTotalSeats(),stations);

    }

    public String save(List<RequestTrainsDTO> trainsList) {
        for (RequestTrainsDTO requestTrainsDTO:trainsList)
        {
            Trains trains=new Trains(requestTrainsDTO.getTrainNo(),requestTrainsDTO.getName(),requestTrainsDTO.getTotalSeat());
            trainRepository.save(trains);
        }
        return "saved successfully";
    }

    public String deleteById(int trainNo) {
        trainRepository.deleteById(trainNo);
        return "deleted successfully";
    }

    public String updateTrain(RequestTrainsDTO requestTrainsDTO) {
        trainRepository.updateTrainById(requestTrainsDTO.getTrainNo(),requestTrainsDTO.getName(),requestTrainsDTO.getTotalSeat());
        return "updated Successfully";
    }
}

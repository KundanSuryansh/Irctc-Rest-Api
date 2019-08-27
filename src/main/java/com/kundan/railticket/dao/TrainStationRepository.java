package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import com.kundan.railticket.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainStationRepository extends JpaRepository<TrainStation,Long> {

    List<TrainStation> getTrainStationByTrain(Trains trains);
}

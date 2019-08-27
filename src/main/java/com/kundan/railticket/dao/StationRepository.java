package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Long> {

    List<Station> getStationByTrainStationList(List<TrainStation> trainStationList);
}

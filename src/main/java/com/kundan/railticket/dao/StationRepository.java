package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Station s SET s.name = :name where s.stationId= :stationId")
    void updateStationById(@Param("stationId") long stationId, @Param("name") String name);
}

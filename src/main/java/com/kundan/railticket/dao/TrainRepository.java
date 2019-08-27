package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Station;
import com.kundan.railticket.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface TrainRepository extends JpaRepository<Trains,Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Trains t SET t.name = :name,t.totalSeats = :totalSeat where t.trainNo= :trainNo")
    void updateTrainById(@Param ("trainNo") int trainNo, @Param("name") String name, @Param("totalSeat") int totalSeat);

    Trains getTrainsByTrainNo(int trainNo);


}

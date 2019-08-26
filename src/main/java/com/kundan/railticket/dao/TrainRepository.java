package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainRepository extends JpaRepository<Trains,Integer> {

}

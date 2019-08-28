package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersRepository extends JpaRepository<Passengers,Long> {


}

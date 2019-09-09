package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Ticket;
import com.kundan.railticket.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket getTicketByPnrNo(long pnrNo);

    List<Ticket> findTicketByTrainAndJourneyDate(Trains trains, Date date);
}

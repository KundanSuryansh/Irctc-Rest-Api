package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket getTicketByPnrNo(long pnrNo);
}

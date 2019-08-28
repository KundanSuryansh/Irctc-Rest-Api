package com.kundan.railticket.controller;

import com.kundan.railticket.dao.TicketRepository;
import com.kundan.railticket.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class TicketController implements Serializable {

    @Autowired
    TicketRepository ticketRepository;

    @PostMapping("/book-ticket")
    Ticket bookTicket(@RequestBody Ticket ticket)
    {
        return ticketRepository.save(ticket);
    }

    @GetMapping("/ticket/{pnrNo}")
    Ticket getTicketByPnrNo(@PathVariable long pnrNo)
    {
        return ticketRepository.getTicketByPnrNo(pnrNo);
    }
}

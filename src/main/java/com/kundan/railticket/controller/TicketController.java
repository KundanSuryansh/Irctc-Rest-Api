package com.kundan.railticket.controller;

import com.kundan.railticket.dao.TicketRepository;
import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.entity.Ticket;
import com.kundan.railticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class TicketController implements Serializable {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book-ticket")
    String bookTicket(@RequestBody RequestTicketDTO ticket)
    {
    return ticketService.saveTicket(ticket);
    }

    @GetMapping("/ticket/{pnrNo}")
   ResponseTicketDTO getTicketByPnrNo(@PathVariable long pnrNo)
    {
        return ticketService.getTicketByPnrNo(pnrNo);
    }
}

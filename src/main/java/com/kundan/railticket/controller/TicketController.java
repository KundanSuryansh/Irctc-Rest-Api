package com.kundan.railticket.controller;

import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/user/book-ticket")
   public String bookTicket(Authentication authentication, @RequestBody RequestTicketDTO ticket)
    {
    return ticketService.saveTicket(authentication.getName(),ticket);
    }

    @GetMapping("/user/ticket/{pnrNo}")
   public ResponseTicketDTO getTicketByPnrNo(@PathVariable long pnrNo)
    {
        return ticketService.getTicketByPnrNo(pnrNo);
    }
}

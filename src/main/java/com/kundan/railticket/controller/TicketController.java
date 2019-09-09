package com.kundan.railticket.controller;

import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.service.TicketService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @ApiOperation(value = "To book ticket")
    @PostMapping("/user/book-ticket")
   public String bookTicket(Authentication authentication, @RequestBody RequestTicketDTO ticket)
    {
    return ticketService.saveTicket(authentication.getName(),ticket);
    }

    @ApiOperation(value = "To get the ticket status through pnr")
    @GetMapping("/user/ticket/{pnrNo}")
   public ResponseTicketDTO getTicketByPnrNo(@PathVariable long pnrNo)
    {
        return ticketService.getTicketByPnrNo(pnrNo);
    }
}

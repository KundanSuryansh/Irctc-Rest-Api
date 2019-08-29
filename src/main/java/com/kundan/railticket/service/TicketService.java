package com.kundan.railticket.service;

import com.kundan.railticket.dao.PassengersRepository;
import com.kundan.railticket.dao.TicketRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.UserRepository;
import com.kundan.railticket.dto.request.RequestPassengersDTO;
import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.entity.Passengers;
import com.kundan.railticket.entity.Ticket;
import com.kundan.railticket.entity.Trains;
import com.kundan.railticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PassengersRepository passengersRepository;

    @Autowired
    Ticket ticket2;


    public String saveTicket(RequestTicketDTO ticket)
    {
        String toStation=ticket.getToStation();
        String fromStation=ticket.getFromStation();
        int NoOfSeat=ticket.getPassengersList().size();
        int fare=100;
        int trainNo=ticket.getTrain().getTrainNo();
        long userId=ticket.getUser().getUserId();
        int seatNo=12;

        List<RequestPassengersDTO> passengersDTOList=ticket.getPassengersList();


        Trains train=trainRepository.getTrainsByTrainNo(trainNo);
        User user=userRepository.getUserByUserId(userId);

       ticket2.setFromStation(fromStation);
       ticket2.setToStation(toStation);
       ticket2.setFare(fare);
       ticket2.setNoOfSeats(NoOfSeat);
       ticket2.setTrain(train);
       ticket2.setUser(user);
        System.out.println(ticket2);
       ticketRepository.save(ticket2);

       for(RequestPassengersDTO passengers : passengersDTOList)
       {
           Passengers passengers1=new Passengers(passengers.getName(),passengers.getGender(),passengers.getAge(),seatNo,ticket2);
           passengersRepository.save(passengers1);
       }

       return new ResponseTicketDTO().addSuccess();


    }
}

package com.kundan.railticket.service;

import com.kundan.railticket.dao.PassengersRepository;
import com.kundan.railticket.dao.TicketRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.UserRepository;
import com.kundan.railticket.dto.request.RequestPassengersDTO;
import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponsePassengersDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.dto.response.ResponseTrainsDTO;
import com.kundan.railticket.entity.Passengers;
import com.kundan.railticket.entity.Ticket;
import com.kundan.railticket.entity.Trains;
import com.kundan.railticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private  TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  PassengersRepository passengersRepository;

    @Autowired
    private  Ticket ticket2;

    public String saveTicket(RequestTicketDTO ticket)
    {
        String toStation=ticket.getToStation();
        String fromStation=ticket.getFromStation();
        int NoOfSeat=ticket.getPassengersList().size();
        int fare=100;
        int trainNo=ticket.getTrainNo();
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
       ticket2=ticketRepository.save(ticket2);

       for(RequestPassengersDTO passengers : passengersDTOList)
       {
           Passengers passengers1=new Passengers(passengers.getName(),passengers.getGender(),passengers.getAge(),seatNo,ticket2);
           passengersRepository.save(passengers1);
       }

        return "Your Ticket got booked and your PNR No is "+ ticket2.getPnrNo();


    }

    public ResponseTicketDTO getTicketByPnrNo(long pnrNo) {
        Ticket ticket=ticketRepository.getTicketByPnrNo(pnrNo);
        List<Passengers> passengersList=ticket.getPassengersList();
        List<ResponsePassengersDTO> responsePassengersDTOList=new ArrayList<>();
        for(Passengers passenger : passengersList)
        {
            ResponsePassengersDTO responsePassengersDTO=new ResponsePassengersDTO(passenger.getName(),passenger.getGender(),passenger.getAge(),passenger.getSeatNo());
            responsePassengersDTOList.add(responsePassengersDTO);
        }
        Trains trains=ticket.getTrains();
        ResponseTicketDTO responseTicketDTO=new ResponseTicketDTO(ticket.getFromStation(),ticket.getToStation(),trains.getTrainNo(),trains.getName(),responsePassengersDTOList);
        return responseTicketDTO;
    }
}

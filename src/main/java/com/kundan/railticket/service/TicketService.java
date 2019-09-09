package com.kundan.railticket.service;

import com.kundan.railticket.dao.PassengersRepository;
import com.kundan.railticket.dao.TicketRepository;
import com.kundan.railticket.dao.TrainRepository;
import com.kundan.railticket.dao.UserRepository;
import com.kundan.railticket.dto.request.RequestPassengersDTO;
import com.kundan.railticket.dto.request.RequestTicketDTO;
import com.kundan.railticket.dto.response.ResponsePassengersDTO;
import com.kundan.railticket.dto.response.ResponseTicketDTO;
import com.kundan.railticket.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengersRepository passengersRepository;


    public String saveTicket(String username, RequestTicketDTO requestTicketDto) {
        TicketBuilder ticketBuilder=new TicketBuilder();
        int noOfSeat = requestTicketDto.getPassengersList().size();
        int fare = 100 * noOfSeat;
        int trainNo = requestTicketDto.getTrainNo();
        long userId = Long.valueOf(username);
        int seatNo = 12;
        Date journeyDate = requestTicketDto.getJourneyDate();
        List<RequestPassengersDTO> passengersDTOList = requestTicketDto.getPassengersList();
        Trains train = trainRepository.getTrainsByTrainNo(trainNo);
        User user = userRepository.getUserByUserId(userId);

        Ticket ticket=ticketRepository.save(ticketBuilder.setFromStation(requestTicketDto.getFromStation())
                .setToStation(requestTicketDto.getToStation())
                .setFare(fare)
                .setNoOfSeats(noOfSeat)
                .setTrain(train)
                .setJourneyDate(journeyDate)
                .setUser(user)
                .getTicket());

        for (RequestPassengersDTO requestPassengersDto : passengersDTOList) {
            Passengers passengers = new Passengers(requestPassengersDto.getName(), requestPassengersDto.getGender(), requestPassengersDto.getAge(), seatNo, ticket);
            passengersRepository.save(passengers);
        }

        return "Your Ticket got booked and your PNR No is " + ticket.getPnrNo();


    }

    public ResponseTicketDTO getTicketByPnrNo(long pnrNo) {
        Ticket ticket = ticketRepository.getTicketByPnrNo(pnrNo);
        List<Passengers> passengersList = ticket.getPassengersList();
        List<ResponsePassengersDTO> responsePassengersDTOList = new ArrayList<>();
        for (Passengers passenger : passengersList) {
            ResponsePassengersDTO responsePassengersDTO = new ResponsePassengersDTO(passenger.getName(), passenger.getGender(), passenger.getAge(), passenger.getSeatNo());
            responsePassengersDTOList.add(responsePassengersDTO);
        }
        Trains trains = ticket.getTrains();
        return new ResponseTicketDTO(ticket.getFromStation(), ticket.getToStation(), trains.getTrainNo(), trains.getName(), ticket.getJourneyDate(), responsePassengersDTOList);

    }
}

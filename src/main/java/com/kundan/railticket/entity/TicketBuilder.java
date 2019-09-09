package com.kundan.railticket.entity;

import java.sql.Date;

public class TicketBuilder {
    private String fromStation;
    private String toStation;
    private int fare;
    private int NoOfSeats;
    private Date journeyDate;
    private User user;
    private Trains train;

    public TicketBuilder(){}

    public TicketBuilder setFromStation(String fromStation) {
        this.fromStation = fromStation;
        return this;
    }

    public TicketBuilder  setToStation(String toStation) {
        this.toStation = toStation;
        return this;
    }

    public TicketBuilder  setFare(int fare) {
        this.fare = fare;
        return this;
    }

    public TicketBuilder  setNoOfSeats(int noOfSeats) {
        NoOfSeats = noOfSeats;
        return this;
    }

    public TicketBuilder  setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
        return this;
    }

    public TicketBuilder  setUser(User user) {
        this.user = user;
        return this;
    }

    public TicketBuilder  setTrain(Trains train) {
        this.train = train;
        return this;
    }
    public Ticket getTicket()
    {
        return new Ticket(fromStation,toStation,journeyDate,train,user);
    }
}

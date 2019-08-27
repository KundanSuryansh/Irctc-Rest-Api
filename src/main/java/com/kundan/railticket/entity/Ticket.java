package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="pnrNo")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long pnrNo;

    private String fromStation;
    private String toStation;
    private int fare;
    private int NoOfSeats;

    @ManyToOne
    Trains train;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "ticket")
    List<Passengers> passengersList;

    Ticket(){}
    public Ticket(String fromStation, String toStation, int fare, int noOfSeats, Trains trains, User user, List<Passengers> passengersList) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.fare = fare;
        NoOfSeats = noOfSeats;
        this.train = trains;
        this.user = user;
        this.passengersList = passengersList;
    }

    public long getPnrNo() {
        return pnrNo;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public int getFare() {
        return fare;
    }

    public int getNoOfSeats() {
        return NoOfSeats;
    }

    public Trains getTrains() {
        return train;
    }

    public User getUser() {
        return user;
    }

    public List<Passengers> getPassengersList() {
        return passengersList;
    }
}

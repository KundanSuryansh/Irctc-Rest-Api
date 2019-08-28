package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JoinColumn(name="train_no")
    Trains train;

    @ManyToOne
    @JoinColumn(name="user_id")
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

    public void setPnrNo(long pnrNo) {
        this.pnrNo = pnrNo;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setNoOfSeats(int noOfSeats) {
        NoOfSeats = noOfSeats;
    }

    public void setTrain(Trains train) {
        this.train = train;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPassengersList(List<Passengers> passengersList) {
        this.passengersList = passengersList;
    }
}

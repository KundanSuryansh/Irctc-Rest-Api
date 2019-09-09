package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="pnrNo")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long pnrNo;

    private String fromStation;
    private String toStation;
    private int fare;
    private int NoOfSeats;
    private Date journeyDate;

    @ManyToOne
    @JoinColumn(name="train_no")
    Trains train;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;


    @OneToMany(mappedBy = "ticket")
    private List<Passengers> passengersList;

    public Ticket(){}

    public Ticket(String fromStation, String toStation, Date journeyDate, Trains train, User user) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.journeyDate = journeyDate;
        this.train = train;
        this.user = user;
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

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "pnrNo=" + pnrNo +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", fare=" + fare +
                ", NoOfSeats=" + NoOfSeats +
                ", journeyDate=" + journeyDate +
                ", train=" + train +
                ", user=" + user +
                ", passengersList=" + passengersList +
                '}';
    }
}

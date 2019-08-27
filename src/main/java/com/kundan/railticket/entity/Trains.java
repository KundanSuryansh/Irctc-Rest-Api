package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="trainNo")
public class Trains implements Serializable {
    @Id
    private int trainNo;

    private String name;
    private  int totalSeats;

    @OneToMany(mappedBy = "train")
    List<Enquires> enquires;

    @OneToMany(mappedBy = "train")
    List<Ticket> tickets;

    @OneToMany(mappedBy = "train")
    List<TrainStation> trainStations;

    Trains(){}
    public Trains(int trainNo, String name, int totalSeats) {
        this.trainNo = trainNo;
        this.name = name;
        this.totalSeats = totalSeats;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public String getName() {
        return name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Enquires> getEnquires() {
        return enquires;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<TrainStation> getTrainstations() {
        return trainStations;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}

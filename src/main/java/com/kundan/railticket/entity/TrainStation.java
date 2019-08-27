package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TrainStation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Trains train;
    @ManyToOne
    private Station station;
    private Time arrivalTime;
    private Time departureTime;

    TrainStation(){}
    public TrainStation(Trains trains, Station stations, Time arrivalTime, Time departureTime) {
        this.train = trains;
        this.station = stations;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public long getId() {
        return id;
    }

    public Trains getTrains() {
        return train;
    }

    public Station getStations() {
        return station;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }
}

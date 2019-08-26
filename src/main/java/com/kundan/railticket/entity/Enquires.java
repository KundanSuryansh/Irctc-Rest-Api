package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="EnquiriesId")
public class Enquires {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long EnquiriesId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Trains train;

    private String fromStation;
    private String toStation;
    private Timestamp timestamp;

    Enquires(){}
    public Enquires(User user, Trains trains, String fromStation, String toStation) {
        this.user = user;
        this.train = trains;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public User getUser() {
        return user;
    }

    public Trains getTrains() {
        return train;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}

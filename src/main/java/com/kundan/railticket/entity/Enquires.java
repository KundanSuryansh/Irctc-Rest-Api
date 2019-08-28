package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="EnquiriesId")
public class Enquires implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long EnquiriesId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "train_no")
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

    public void setEnquiriesId(long enquiriesId) {
        EnquiriesId = enquiriesId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTrain(Trains train) {
        this.train = train;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

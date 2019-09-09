package com.kundan.railticket.dto.response;

import java.sql.Date;
import java.util.List;


public class ResponseTicketDTO{

     String fromStation;
     String toStation;
     int trainNo;
     String trainName;
     Date journeyDate;
     List<ResponsePassengersDTO> passengersList;

    public ResponseTicketDTO(){}

    public ResponseTicketDTO(String fromStation, String toStation, int trainNo, String trainName, Date journeyDate, List<ResponsePassengersDTO> passengersList) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.journeyDate = journeyDate;
        this.passengersList = passengersList;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<ResponsePassengersDTO> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<ResponsePassengersDTO> passengersList) {
        this.passengersList = passengersList;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }
}

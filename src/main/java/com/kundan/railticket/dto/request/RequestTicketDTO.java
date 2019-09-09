package com.kundan.railticket.dto.request;

import java.sql.Date;
import java.util.List;

public class RequestTicketDTO {
    private String fromStation;
    private String toStation;
    int trainNo;
    private Date journeyDate;
    private List<RequestPassengersDTO> passengersList;

    public RequestTicketDTO() {
    }

    public RequestTicketDTO(String fromStation, String toStation, int trainNo, Date journeyDate) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainNo = trainNo;
        this.journeyDate = journeyDate;
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


    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public List<RequestPassengersDTO> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<RequestPassengersDTO> passengersList) {
        this.passengersList = passengersList;
    }
}

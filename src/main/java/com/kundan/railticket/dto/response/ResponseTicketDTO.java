package com.kundan.railticket.dto.response;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


public class ResponseTicketDTO{

     String fromStation;
     String toStation;
    ResponseTrainsDTO train;
     List<ResponsePassengersDTO> passengersList;

    public ResponseTicketDTO(){}

    public ResponseTicketDTO(String fromStation, String toStation, ResponseTrainsDTO train, List<ResponsePassengersDTO> passengersList) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.train = train;
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

    public ResponseTrainsDTO getTrain() {
        return train;
    }

    public void setTrain(ResponseTrainsDTO train) {
        this.train = train;
    }

    public List<ResponsePassengersDTO> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<ResponsePassengersDTO> passengersList) {
        this.passengersList = passengersList;
    }

}

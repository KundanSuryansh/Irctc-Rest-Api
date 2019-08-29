package com.kundan.railticket.dto.request;

import java.util.List;

public class RequestTicketDTO {
    private String fromStation;
    private String toStation;
    int trainNo;
    String trainName;
    RequestUserDTO user;
    private List<RequestPassengersDTO> passengersList;

    public RequestTicketDTO() {
    }

    public RequestTicketDTO(String fromStation, String toStation, int trainNo, String trainName, RequestUserDTO user, List<RequestPassengersDTO> passengersList) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.user = user;
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

    public RequestUserDTO getUser() {
        return user;
    }

    public void setUser(RequestUserDTO user) {
        this.user = user;
    }

    public List<RequestPassengersDTO> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<RequestPassengersDTO> passengersList) {
        this.passengersList = passengersList;
    }
}

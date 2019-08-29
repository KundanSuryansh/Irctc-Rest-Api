package com.kundan.railticket.dto.request;

import java.util.List;

public class RequestTicketDTO {
    private String fromStation;
    private String toStation;
    RequestTrainsDTO train;
    RequestUserDTO user;
    private List<RequestPassengersDTO> passengersList;

    public RequestTicketDTO() {
    }

    public RequestTicketDTO(String fromStation, String toStation, RequestTrainsDTO train, RequestUserDTO user, List<RequestPassengersDTO> passengersList) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.train = train;
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

    public RequestTrainsDTO getTrain() {
        return train;
    }

    public void setTrain(RequestTrainsDTO train) {
        this.train = train;
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

    @Override
    public String toString() {
        return "RequestTicketDTO{" +
                "fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", train=" + train +
                ", user=" + user +
                ", passengersList=" + passengersList +
                '}';
    }
}

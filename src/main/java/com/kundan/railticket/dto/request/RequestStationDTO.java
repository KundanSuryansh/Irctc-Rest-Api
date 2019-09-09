package com.kundan.railticket.dto.request;

public class RequestStationDTO {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RequestStationDTO(String name) {
        this.name = name;
    }
}

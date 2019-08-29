package com.kundan.railticket.dto.request;

public class RequestStationDTO {
    long stationId;
    String stationName;

    public RequestStationDTO(long stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}

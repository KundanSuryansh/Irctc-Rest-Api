package com.kundan.railticket.dto.response;

import java.util.List;

public class ResponseTrainsDTO {

     int trainNo;
     String name;
     int totalSeat;
     List<String> stations;

    public ResponseTrainsDTO(){}

    public ResponseTrainsDTO(int trainNo, String name, int totalSeat, List<String> stations) {
        this.trainNo = trainNo;
        this.name = name;
        this.totalSeat = totalSeat;
        this.stations = stations;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
}

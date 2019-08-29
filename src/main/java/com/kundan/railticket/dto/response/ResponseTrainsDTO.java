package com.kundan.railticket.dto.response;





public class ResponseTrainsDTO {

     int trainNo;
     String name;
     int totalSeat;

    public ResponseTrainsDTO(){}

    public ResponseTrainsDTO(int trainNo, String name, int totalSeat) {
        this.trainNo = trainNo;
        this.name = name;
        this.totalSeat = totalSeat;
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
}

package com.kundan.railticket.dto.request;

public class RequestTrainsDTO {
    private int trainNo;
    private String name;
    int totalSeat;

    public RequestTrainsDTO(int trainNo, String name, int totalSeat) {
        this.trainNo = trainNo;
        this.name = name;
        this.totalSeat = totalSeat;
    }

    public RequestTrainsDTO(){}

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

    @Override
    public String toString() {
        return "RequestTrainsDTO{" +
                "trainNo=" + trainNo +
                ", name='" + name + '\'' +
                '}';
    }
}

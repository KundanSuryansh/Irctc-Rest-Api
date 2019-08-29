package com.kundan.railticket.dto.request;

public class RequestTrainsDTO {
    private int trainNo;
    private String name;

    public RequestTrainsDTO(int trainNo, String name) {
        this.trainNo = trainNo;
        this.name = name;
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

    @Override
    public String toString() {
        return "RequestTrainsDTO{" +
                "trainNo=" + trainNo +
                ", name='" + name + '\'' +
                '}';
    }
}

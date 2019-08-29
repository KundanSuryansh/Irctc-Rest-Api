package com.kundan.railticket.dto.response;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public class ResponseTrainsDTO {

     int trainNo;
     String name;

    public ResponseTrainsDTO(){}
    public ResponseTrainsDTO(int trainNo, String name) {
        this.trainNo = trainNo;
        this.name = name;
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
}

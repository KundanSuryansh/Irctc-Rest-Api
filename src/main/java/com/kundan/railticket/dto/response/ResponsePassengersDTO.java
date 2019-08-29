package com.kundan.railticket.dto.response;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public class ResponsePassengersDTO {
     String name;
     String gender;
    int age;
    int seatNo;

    public ResponsePassengersDTO(String name, String gender, int age, int seatNo) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.seatNo = seatNo;
    }

    public ResponsePassengersDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}

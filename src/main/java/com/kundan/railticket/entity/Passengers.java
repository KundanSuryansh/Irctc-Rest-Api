package com.kundan.railticket.entity;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="passengerId")
public class Passengers {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long passengersId;

    private String name;
    private String gender;
    private int age;
    int seatNo;

    @ManyToOne
    private Ticket ticket;

    Passengers(){}
    public Passengers(String name, String gender, int age, int seatNo, Ticket ticket) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.seatNo = seatNo;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    public int getSeatNo() {
        return seatNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public Ticket getTickets() {
        return ticket;
    }

    public void setTickets(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", seatNo=" + seatNo +
                '}';
    }
}

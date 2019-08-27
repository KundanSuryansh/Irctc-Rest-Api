package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;

    private  String name;

    @OneToMany(mappedBy = "user")
    private List<Enquires> enquiresList;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> ticketSet;

    User(){}
    public User(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnquiresList(List<Enquires> enquiresList) {
        this.enquiresList = enquiresList;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}

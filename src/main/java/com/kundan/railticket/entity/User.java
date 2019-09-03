package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Enquires> enquiresList;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> ticketSet;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Roles> roles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enquiresList=" + enquiresList +
                ", ticketSet=" + ticketSet +
                ", roles=" + roles +
                '}';
    }
}

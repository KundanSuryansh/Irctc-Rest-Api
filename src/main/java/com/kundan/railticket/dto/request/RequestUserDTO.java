package com.kundan.railticket.dto.request;

import javax.validation.constraints.NotNull;

public class RequestUserDTO {

    @NotNull
    private  String name;
    @NotNull
    private String password;

    public RequestUserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    RequestUserDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestUserDTO{" +
                "userId=" +
                ", name='" + name + '\'' +
                '}';
    }
}


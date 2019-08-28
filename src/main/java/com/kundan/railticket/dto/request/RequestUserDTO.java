package com.kundan.railticket.dto.request;

public class RequestUserDTO {
    private long userId;
    private  String name;

    public RequestUserDTO(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    RequestUserDTO(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.kundan.railticket.dto.response;



public class ResponseUserDTO {

    long userId;
    String name;

    public ResponseUserDTO(){}
    public ResponseUserDTO(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

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

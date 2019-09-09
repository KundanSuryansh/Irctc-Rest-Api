package com.kundan.railticket.controller;

import com.kundan.railticket.dto.request.RequestUserDTO;
import com.kundan.railticket.exceptions.NoNameFoundException;
import com.kundan.railticket.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "to create user")
    @PostMapping("/sign-up")
    public String addUser(@Valid @RequestBody RequestUserDTO userDTO)
    {
        return userService.addMember(userDTO);
    }

}

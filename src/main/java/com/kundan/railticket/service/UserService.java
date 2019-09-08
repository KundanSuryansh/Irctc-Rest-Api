package com.kundan.railticket.service;

import com.kundan.railticket.dao.RoleRepository;
import com.kundan.railticket.dao.UserRepository;
import com.kundan.railticket.dto.request.RequestUserDTO;
import com.kundan.railticket.entity.Roles;
import com.kundan.railticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    public String addMember(RequestUserDTO userDTO) {
    String name=userDTO.getName();
    String password=userDTO.getPassword();
    User user=new User(name,password);
    Long id=userRepository.save(user).getUserId();
    Roles roles=new Roles("USER",user);
    roleRepository.save(roles);
    return "Your User Id is "+id;
    }
}

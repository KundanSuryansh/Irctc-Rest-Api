package com.kundan.railticket.service;

import com.kundan.railticket.dao.UserRepository;
import com.kundan.railticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.getUserByUserId(Long.valueOf(s));
        if(user==null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}

package com.kundan.railticket.dao;

import com.kundan.railticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByUserId(long userId);
}

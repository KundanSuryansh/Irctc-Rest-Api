package com.kundan.railticket.dao;

import com.kundan.railticket.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Roles,Integer> {

}

package com.hospital.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

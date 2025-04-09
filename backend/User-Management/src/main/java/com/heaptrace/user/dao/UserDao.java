package com.heaptrace.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heaptrace.user.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}

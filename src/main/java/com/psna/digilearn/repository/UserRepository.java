package com.psna.digilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psna.digilearn.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByRoleId(int role_id);
}

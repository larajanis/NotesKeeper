package com.psna.digilearn.service;

import java.util.List;

import com.psna.digilearn.model.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
    
    List<User> findStaff();
}
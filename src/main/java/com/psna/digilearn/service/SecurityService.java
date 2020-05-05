package com.psna.digilearn.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
package com.example.santander.dio.domain.service;

import com.example.santander.dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    void deleteById(Long id);


}

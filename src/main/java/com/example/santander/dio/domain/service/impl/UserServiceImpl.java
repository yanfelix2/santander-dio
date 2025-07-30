package com.example.santander.dio.domain.service.impl;

import com.example.santander.dio.domain.model.User;
import com.example.santander.dio.domain.repository.UserRepository;
import com.example.santander.dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    // CAMADA DE NEGOCIOS.

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists");

        }
        return userRepository.save(userToCreate);
    }

}

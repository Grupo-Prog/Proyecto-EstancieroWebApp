package com.estanciero.api.service.impl;

import com.estanciero.api.dto.UserCreateRequestDTO;
import com.estanciero.api.dto.UserResponseDTO;
import com.estanciero.api.dto.UserUpdateRequestDTO;
import com.estanciero.api.mapper.UserMapper;
import com.estanciero.api.model.repository.UserRepository;
import com.estanciero.api.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO findById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(null);

    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserResponseDTO> findByName(String name) {
        return List.of();
    }

    @Override
    public UserResponseDTO create(UserCreateRequestDTO request) {
        return null;
    }

    @Override
    public UserResponseDTO update(long id, UserUpdateRequestDTO request) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}

package com.estanciero.api.services;

import com.estanciero.api.dtos.user.UserCreateRequestDTO;
import com.estanciero.api.dtos.user.UserResponseDTO;
import com.estanciero.api.dtos.user.UserUpdateRequestDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDTO> findAll();

    Optional<UserResponseDTO> findById(long id);

    Optional<UserResponseDTO> findByEmail(String email);

    List<UserResponseDTO> findByName(String name);

    UserResponseDTO create(UserCreateRequestDTO request);

    UserResponseDTO update(long id, UserUpdateRequestDTO request);

    void deleteById(long id);

    UserResponseDTO login(String email, String password);



}

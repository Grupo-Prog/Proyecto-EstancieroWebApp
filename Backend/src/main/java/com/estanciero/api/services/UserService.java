package com.estanciero.api.services;

import com.estanciero.api.dtos.UserCreateRequestDTO;
import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.dtos.UserUpdateRequestDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(long id);

    UserResponseDTO findByEmail(String email);

    List<UserResponseDTO> findByName(String name);

    UserResponseDTO create(UserCreateRequestDTO request);

    UserResponseDTO update(long id, UserUpdateRequestDTO request);

    void deleteById(long id);

}

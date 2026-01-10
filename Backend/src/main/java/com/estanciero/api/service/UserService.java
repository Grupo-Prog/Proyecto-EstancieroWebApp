package com.estanciero.api.service;

import com.estanciero.api.dto.UserCreateRequestDTO;
import com.estanciero.api.dto.UserResponseDTO;
import com.estanciero.api.dto.UserUpdateRequestDTO;

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

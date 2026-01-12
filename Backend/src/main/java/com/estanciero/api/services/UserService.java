package com.estanciero.api.services;

import com.estanciero.api.dtos.UserCreateRequestDTO;
import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.dtos.UserUpdateRequestDTO;
import com.estanciero.api.models.enums.UserStatusType;

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



}

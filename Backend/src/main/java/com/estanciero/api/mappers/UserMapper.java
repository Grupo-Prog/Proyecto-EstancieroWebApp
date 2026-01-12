package com.estanciero.api.mappers;

import com.estanciero.api.dtos.UserCreateRequestDTO;
import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.dtos.UserUpdateRequestDTO;
import com.estanciero.api.models.entities.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public User toEntityCreate(UserCreateRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User toEntityUpdate(User user, UserUpdateRequestDTO dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

}

package com.estanciero.api.mapper;

import com.estanciero.api.dto.UserResponseDTO;
import com.estanciero.api.model.entity.User;
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

}

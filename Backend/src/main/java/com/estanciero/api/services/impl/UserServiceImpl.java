package com.estanciero.api.services.impl;

import com.estanciero.api.dtos.UserCreateRequestDTO;
import com.estanciero.api.dtos.UserResponseDTO;
import com.estanciero.api.dtos.UserUpdateRequestDTO;
import com.estanciero.api.mappers.UserMapper;
import com.estanciero.api.models.entities.User;
import com.estanciero.api.models.enums.UserStatusType;
import com.estanciero.api.repositories.UserRepository;
import com.estanciero.api.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAllByStatus(UserStatusType.ACTIVE)
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<UserResponseDTO> findById(long id) {
        return userRepository.findByIdAndStatus(id, UserStatusType.ACTIVE)
                .map(userMapper::toDTO);

    }

    @Override
    public Optional<UserResponseDTO> findByEmail(String email) {
        return userRepository.findByEmailAndStatus(email, UserStatusType.ACTIVE)
                .map(userMapper::toDTO);
    }

    @Override
    public List<UserResponseDTO> findByName(String name) {
        return userRepository.findAllByNameAndStatus(name, UserStatusType.ACTIVE)
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO create(UserCreateRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El e-mail ya ha sido utilizado");
        }
        if (userRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("El nombre ya ha sido utilizado");
        }
        if (request.getPassword().length() < 6) {
            throw new IllegalArgumentException("La contraseña es demasiado corta");
        }
        if (request.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede quedar vacío");
        }
        if (request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El e-mail no puede quedar vacío");
        }

        User user = userMapper.toEntityCreate(request);
        user.setStatus(UserStatusType.ACTIVE);

        User createdUser = userRepository.save(user);

        return userMapper.toDTO(createdUser);

    }

    @Override
    public UserResponseDTO update(long id, UserUpdateRequestDTO request) {

        Optional<User> optionalUser =
                userRepository.findByIdAndStatus(id, UserStatusType.ACTIVE);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (request.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede quedar vacío");
        }
        if (request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El e-mail no puede quedar vacío");
        }

        User user = optionalUser.get();

        if (!user.getEmail().equals(request.getEmail()) && userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El e-mail ya ha sido utilizado");
        }

        if (!user.getName().equals(request.getName()) && userRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("El nombre ya ha sido utilizado");
        }

        userMapper.toEntityUpdate(user, request);

        User updatedUser = userRepository.save(user);

        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteById(long id) {

        Optional<User> optionalUser =
                userRepository.findByIdAndStatus(id, UserStatusType.ACTIVE);
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        User user = optionalUser.get();
        user.setStatus(UserStatusType.DELETED);

        userRepository.save(user);
    }


    // Opcional: crear método que haga validaciones para luego llamarlo y no escribirlo dos veces

}

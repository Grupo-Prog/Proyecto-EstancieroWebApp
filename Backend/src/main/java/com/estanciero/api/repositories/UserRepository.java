package com.estanciero.api.repositories;

import com.estanciero.api.models.entities.User;
import com.estanciero.api.models.enums.UserStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByName(String name);

    List<User> findAllByStatus(UserStatusType status);

    Optional<User> findByEmailAndStatus(String email, UserStatusType status);

    List<User> findAllByNameAndStatus(String name, UserStatusType status);

    Optional<User> findByIdAndStatus(long id, UserStatusType status);


}

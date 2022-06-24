package com.simplform.Registrationform.repository;

import com.simplform.Registrationform.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersModel,Integer> {
    Optional <String> findByLoginAndPassword(String login, String password);

    Optional<UsersModel> findByLogin(String login);
}

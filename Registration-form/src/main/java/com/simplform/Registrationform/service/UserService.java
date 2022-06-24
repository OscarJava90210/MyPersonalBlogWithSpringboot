package com.simplform.Registrationform.service;

import com.simplform.Registrationform.model.UsersModel;
import com.simplform.Registrationform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersModel registerUser(String login, String password, String email) {
        if(login !=null && password !=null ) {
            return null;
        }else {
            if(userRepository.findByLogin(login).isPresent()){
                System.out.println("Duplicate");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return userRepository.save(usersModel);
        }
    }
    public String authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}

package com.tb.teya.test.service;

import com.tb.teya.test.entity.UserEntity;
import com.tb.teya.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public List<UserEntity> retrieveUsers(){

        return userRepository.findAll();
    }

    public UserEntity userCreate(UserEntity userEntity){

        userEntity.setActive(true);
        return userRepository.save(userEntity);
    }
}

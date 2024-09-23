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


    /**
     * Get all users
     * @return List<UserEntity>
     */
    public List<UserEntity> retrieveUsers(){
        return userRepository.findAll();
    }

    /**
     * Create user
     * @param userEntity UserEntity
     * @return UserEntity
     */
    public UserEntity userCreate(UserEntity userEntity){

        userEntity.setActive(true);
        return userRepository.save(userEntity);
    }
}

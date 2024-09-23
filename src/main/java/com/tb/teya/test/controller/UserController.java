package com.tb.teya.test.controller;

import com.tb.teya.test.entity.UserEntity;
import com.tb.teya.test.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserEntity>> retrieveUsers() {
        List<UserEntity> userEntityListResponse = userService.retrieveUsers();

        return ResponseEntity.ok(userEntityListResponse);
    }

    @PostMapping
    public ResponseEntity<UserEntity> userCreate(@Valid @RequestBody UserEntity userEntityRequest){

        UserEntity userEntitySaved = userService.userCreate(userEntityRequest);

        return ResponseEntity.ok(userEntitySaved);
    }

}

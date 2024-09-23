package com.tb.teya.test.controller;

import com.tb.teya.test.entity.AccountEntity;
import com.tb.teya.test.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/accounts")
@RequiredArgsConstructor
@RestController
public class AccountController {


    private final AccountService accountService;


    @PostMapping("/users/{userId}")
    public AccountEntity createAccount(@PathVariable Long userId, @RequestParam String accountName) {
        return accountService.accountCreate(userId, accountName);
    }

    @GetMapping()
    public ResponseEntity<List<AccountEntity>> retrieveAccounts() {
        List<AccountEntity> accountEntityList = accountService.retrieveAccounts();

        return ResponseEntity.ok(accountEntityList);
    }

    @GetMapping("/{id}")
    public AccountEntity getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

}

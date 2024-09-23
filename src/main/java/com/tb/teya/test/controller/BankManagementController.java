package com.tb.teya.test.controller;

import com.tb.teya.test.entity.AccountEntity;
import com.tb.teya.test.entity.TransactionEntity;
import com.tb.teya.test.service.BankManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bank")
@RequiredArgsConstructor
@RestController
public class BankManagementController {

    private final BankManagementService bankManagementService;

    @PostMapping("/accounts/{accountId}/deposit")
    public AccountEntity deposit(@PathVariable Long accountId, @RequestParam Double amount) {
        return bankManagementService.deposit(accountId, amount);
    }

    @PostMapping("/accounts/{accountId}/withdraw")
    public AccountEntity withdraw(@PathVariable Long accountId, @RequestParam Double amount) {
        return bankManagementService.withdraw(accountId, amount);
    }

    @PostMapping("/accounts/transfer")
    public void transfer(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam Double amount) {
        bankManagementService.transfer(fromAccountId, toAccountId, amount);
    }

    @GetMapping("/accounts/{accountId}/transactions")
    public List<TransactionEntity> getTransactionHistory(@PathVariable Long accountId) {
        return bankManagementService.getTransactionHistory(accountId);
    }
}

package com.tb.teya.test.service;

import com.tb.teya.test.entity.AccountEntity;
import com.tb.teya.test.entity.TransactionEntity;
import com.tb.teya.test.enums.TransactionTypeEnum;
import com.tb.teya.test.repository.AccountRepository;
import com.tb.teya.test.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BankManagementService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;



    /**
     * Deposit into an account
     * @param accountId Long
     * @param amount Double
     * @return AccountEntity
     */
    @Transactional
    public AccountEntity deposit(Long accountId, Double amount) {
        AccountEntity account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        createTransaction(account, TransactionTypeEnum.DEPOSIT, amount, null, null);
        return accountRepository.save(account);
    }

    /**
     * Withdraw from an account
     * @param accountId Long
     * @param amount Double
     * @return AccountEntity
     */
    @Transactional
    public AccountEntity withdraw(Long accountId, Double amount) {
        AccountEntity accountEntity = accountRepository.findById(accountId).orElseThrow();
        if (accountEntity.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        accountEntity.setBalance(accountEntity.getBalance() - amount);
        createTransaction(accountEntity, TransactionTypeEnum.WITHDRAWAL, amount, null, null);
        return accountRepository.save(accountEntity);
    }

    /**
     * Transfer between accounts
     * @param fromAccountId Long
     * @param toAccountId Long
     * @param amount Double
     */
    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, Double amount) {
        AccountEntity accountEntityFromAccount = accountRepository.findById(fromAccountId).orElseThrow();
        AccountEntity accountEntityToAccount = accountRepository.findById(toAccountId).orElseThrow();

        if (accountEntityFromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds for transfer");
        }

        // Deduct from sender account
        accountEntityFromAccount.setBalance(accountEntityFromAccount.getBalance() - amount);
        accountRepository.save(accountEntityFromAccount);

        // Add to receiver account
        accountEntityToAccount.setBalance(accountEntityToAccount.getBalance() + amount);
        accountRepository.save(accountEntityToAccount);

        createTransaction(accountEntityFromAccount, TransactionTypeEnum.TRANSFER,
                amount, accountEntityFromAccount.getAccountName(), accountEntityToAccount.getAccountName());
    }

    /**
     * Transaction history
     * @param accountId Long
     * @return List<TransactionEntity>
     */
    public List<TransactionEntity> getTransactionHistory(Long accountId) {
        AccountEntity accountEntity = accountRepository.findById(accountId).orElseThrow();
        return transactionRepository.findByAccountEntity(accountEntity);
    }

    /**
     * method to help to create a transaction
     * @param accountEntity AccountEntity
     * @param type TransactionTypeEnum
     * @param amount Double
     * @param fromAccount String - who is sending
     * @param toAccount String - who is receiving
     */
    private void createTransaction(AccountEntity accountEntity, TransactionTypeEnum type, Double amount, String fromAccount, String toAccount) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAccountEntity(accountEntity);

        transactionRepository.save(transaction);
    }

}

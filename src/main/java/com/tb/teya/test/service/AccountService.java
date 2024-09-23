package com.tb.teya.test.service;

import com.tb.teya.test.entity.AccountEntity;
import com.tb.teya.test.entity.UserEntity;
import com.tb.teya.test.repository.AccountRepository;
import com.tb.teya.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;


    /**
     * Get account by id
     * @param id Long
     * @return Optional<AccountEntity>
     */
    public Optional<AccountEntity> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    /**
     * Create a new account for a user
     * @param userId Long
     * @param accountName String
     * @return AccountEntity
     */
    public AccountEntity accountCreate(Long userId, String accountName) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setBalance(0.0);
        accountEntity.setAccountName(accountName);
        accountEntity.setUserEntity(userEntity);
        return accountRepository.save(accountEntity);
    }

    /**
     * Get all accounts
     * @return List<AccountEntity>
     */
    public List<AccountEntity> retrieveAccounts(){

        return accountRepository.findAll();
    }

}

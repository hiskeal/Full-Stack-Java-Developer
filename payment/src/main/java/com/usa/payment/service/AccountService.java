package com.usa.payment.service;

import com.usa.payment.Dto.AccountRequestDto;
import com.usa.payment.Dto.AccountResponseDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Account;
import com.usa.payment.repository.AccountRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class AccountService {
    @Qualifier("accountRepository")
     @Autowired
    private AccountRepository accountRepository;


    public ResponseDto saveAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountStatus("Active");

        account.setBalance(accountRequestDto.getBalance());
        account.setPersonId(accountRequestDto.getPersonId());
        account.setCreatedOn(new Date());
        account.setUpdatedOn(Instant.now());

        accountRepository.save(account);

        return new ResponseDto(true, "Registered Successfully");
    }

    public ResponseDto updateAccount(Long id, AccountRequestDto accountRequestDto) {

        Account account = accountRepository.findById(id).get();
        account.setBalance(accountRequestDto.getBalance());
        account.setPersonId(accountRequestDto.getPersonId());
        account.setCreatedOn(new Date());

        account.setUpdatedOn(Instant.now());

        accountRepository.save(account);
        return new ResponseDto(true, "Updated Method");

    }

    public ResponseDto deleteAccountById(Long id) {

        accountRepository.deleteById(id);

        return new ResponseDto(true, "deleted successfully");
    }

    public Account getAccountById(Long id) {

     return accountRepository.findById(id).get();
       // return new ResponseDto(true, "Get Each Result By Id");

    }

    public List<Account> ListAll() {
        List<AccountResponseDto> accountResponseDto = new ArrayList<>();
        return (List<Account>) accountRepository.findAll();
    }

    public ResponseDto active(Long id) {
        Account account = accountRepository.findById(id).get();
        if (account.getAccountStatus().equals("Activate")){
            account.setAccountStatus("Deactivate");
    } else if (account.getAccountStatus().equals("Deactivate")) {
            account.setAccountStatus("Activate");
        }

        accountRepository.save(account);
           return new ResponseDto(true, "Active or Deactivate");

        }
    }
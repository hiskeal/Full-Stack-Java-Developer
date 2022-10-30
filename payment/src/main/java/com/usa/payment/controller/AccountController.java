package com.usa.payment.controller;

import com.usa.payment.Dto.AccountRequestDto;
import com.usa.payment.Dto.ResponseDto;

import com.usa.payment.model.Account;
import com.usa.payment.service.AccountService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/saveAccount")
    public ResponseDto saveAccount(@RequestBody AccountRequestDto accountRequestDto) {
         accountService.saveAccount(accountRequestDto);
        return new ResponseDto(true, "Updated Account Successfully");
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseDto updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto accountRequestDto) {
         accountService.updateAccount(id,accountRequestDto);
         return new ResponseDto(true, "Updated Account Successfully");
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseDto deleteAccount(@PathVariable("id") Long id) {
          accountService.deleteAccountById(id);

        return new ResponseDto(true, "Deleted Account Successfully");
    }

    @GetMapping("/listAccount")
    public List<Account> ListAll() {
        return accountService.ListAll();
    }

    @GetMapping("/getAccount/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/active/{id}")
    public ResponseDto active(@PathVariable Long id) {
        return accountService.active(id);
    }
}

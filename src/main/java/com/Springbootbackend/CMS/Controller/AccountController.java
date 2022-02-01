package com.Springbootbackend.CMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import com.Springbootbackend.CMS.Model.Account;
import com.Springbootbackend.CMS.Services.AccountServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountServices accountService;

    @PostMapping("account/create")
    ResponseEntity<Account> createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @PostMapping("account/get")
    ResponseEntity<Account> getAccount(@RequestBody String id){
        Account account = accountService.getAccount(Long.valueOf(id)).orElse(new Account());
        if(account.getId().toString().isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @PostMapping("account/update")
    ResponseEntity<Account> updateAccount(@RequestBody Account account){
        Account updatedAccount;
        if(accountService.updateAccount(account).getId().toString().isEmpty())
            return new ResponseEntity<>(new Account(), HttpStatus.NOT_FOUND);
        updatedAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
    @PostMapping("account/delete")
    ResponseEntity<String> deleteAccount(@RequestBody String id){
        if(!accountService.getAccount(Long.valueOf(id)).isPresent()){
            return new ResponseEntity<>("Account Not Found!",HttpStatus.NOT_FOUND);
        }
        accountService.deleteAccount(Long.valueOf(id));

        return new ResponseEntity<>("Account with id " + id + " has been successfully deleted!", HttpStatus.OK);
    }
    @PostMapping("account/customerPosition")
    ResponseEntity<String> getCustomerPosition(@RequestBody String id){
        String customerPosition = accountService.getCustomerPosition(Long.valueOf(id));
        return new ResponseEntity<>(customerPosition, HttpStatus.OK);
    }
}


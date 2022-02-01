package com.Springbootbackend.CMS.Services;

import com.Springbootbackend.CMS.Model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface AccountServices {

    void createAccount(Account account);

    Optional<Account> getAccount(Long id);

    Account updateAccount(Account account);

    void deleteAccount(Long id);

    String getCustomerPosition(Long id);
}

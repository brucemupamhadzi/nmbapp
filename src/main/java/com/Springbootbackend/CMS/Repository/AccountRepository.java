package com.Springbootbackend.CMS.Repository;

import com.Springbootbackend.CMS.Model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByDebitAccount(String accountnumber);

    Account findByCreditAccount(String accountnumber);
}


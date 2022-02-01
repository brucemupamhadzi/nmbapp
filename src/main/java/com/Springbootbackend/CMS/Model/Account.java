package com.Springbootbackend.CMS.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor

@Entity
@Table (name ="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="account_number")
    private String accountNumber;

    @Column (name ="date_of_creation")
    private String dateOfCreation;

    @Column (name ="Currency")
    private String currency;

    @Column(name ="Mobile_Number" )
    private String mobileNumber;

    @Column (name ="Branch")
    private String branch;

    @Column (name = "Initial_balance")
    private String initialBalance;

    @Column (name ="active_balance")
    private String activeBalance;

    @Column (name ="debit_amount")
    private String debitAmount;

    @Column (name ="credit_amount")
    private String creditAmount;

    @Column (name ="debit_narration")
    private String debitNarration;

    @Column (name ="Credit_narration")
    private String creditNarration;


}

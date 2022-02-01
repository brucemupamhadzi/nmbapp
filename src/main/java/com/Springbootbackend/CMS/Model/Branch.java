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
@Table (name ="branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "branch_Address")
    private String branchAddress;

    /*@Column (name ="First_name")
    private String Firstname;

    @Column (name ="Surname")
    private String surname;

    @Column (name =" National_id")
    private String nationalId;

    @Column(name ="Title" )
    private String title;

    @Column(name ="account_number")
    private String accountNumber;

     */




}

package com.Springbootbackend.CMS.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor

@Table (name ="customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="First_name")
    private String Firstname;

    @Column (name ="Surname")
    private String surname;

    @Column (name =" National_id")
    private String nationalId;

    @Column(name ="Title" )
    private String title;

    @Column (name ="Home_owner")
    private String homeowner;

    @Column (name = "Email_Address")
    private String email;

    @Column (name ="Gender")
    private String gender;

    @Column (name ="user_name")
    private String username;

}

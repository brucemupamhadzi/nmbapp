package com.Springbootbackend.CMS.Repository;


import com.Springbootbackend.CMS.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_Management_systemRepository extends JpaRepository <Customer, Long> {

    // All CRUD OPERATIONS METHODS TO INTERACT WITH THE DB



}


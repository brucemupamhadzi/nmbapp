package com.Springbootbackend.CMS.Repository;


import com.Springbootbackend.CMS.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}


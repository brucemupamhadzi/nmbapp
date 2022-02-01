package com.Springbootbackend.CMS.Services;

import com.Springbootbackend.CMS.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    void createCustomer(Customer customer);

    Optional<Customer> getCustomer(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}

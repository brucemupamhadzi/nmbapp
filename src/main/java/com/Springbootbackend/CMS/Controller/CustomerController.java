package com.Springbootbackend.CMS.Controller;

import com.Springbootbackend.CMS.Model.Customer;
import com.Springbootbackend.CMS.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("customer/create")
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }
    @PostMapping("customer/get")
    ResponseEntity<Customer> getCustomer(@RequestBody String id){
        Customer customer = customerService.getCustomer(Long.valueOf(id)).orElse(new Customer());
        if(customer.getId().toString().isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }
    @PostMapping("customer/update")
    ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updatedCustomer;
        if(customerService.updateCustomer(customer).getId().toString().isEmpty())
            return new ResponseEntity<>(new Customer(), HttpStatus.NOT_FOUND);
        updatedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }
    @PostMapping("customer/delete")
    ResponseEntity<String> deleteCustomer(@RequestBody String id){
        if(!customerService.getCustomer(Long.valueOf(id)).isPresent()){
            return new ResponseEntity<>("Customer Not Found!",HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(Long.valueOf(id));

        return new ResponseEntity<>("Customer with id " + id + " has been successfully deleted!", HttpStatus.OK);
    }

}





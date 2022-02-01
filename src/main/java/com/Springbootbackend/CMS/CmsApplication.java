package com.Springbootbackend.CMS;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);





   /* @Autowired
    private Customer_Management_systemRepository customerManagementSystemRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer1 =new Customer();
        customer1.setFirstname("bruce");
        customer1.setSurname("mupamhadzi");
        customer1.setId('1');
        customer1.setEmail("biemup@gmail.com");
        customer1.setGender("male");
        customer1.setHomeowner("yes");
        customer1.setTitle("Mr");
        customer1.setUsername("bie");
        customer1.setNationalId("63_601904605");
        customerManagementSystemRepository.save(customer1);

        Customer customer2 =new Customer();
        customer2.setFirstname("tom");
        customer2.setSurname("cat");
        customer2.setId('2');
        customer2.setEmail("catt@gmail.com");
        customer2.setGender("female");
        customer2.setHomeowner("no");
        customer2.setTitle("Mrs");
        customer2.setUsername("tee");
        customer2.setNationalId("45_601904605");
        customerManagementSystemRepository.save(customer2);

    */


    }
}

package net.malick.customerservice;

import net.malick.customerservice.entities.Customer;
import net.malick.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {



    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService){
       return args -> {
           List<String> names= List.of("malick","djeinabou","ahmadou");
           names.forEach(name->{
               customerService.saveCustomer(Customer.builder()
                       .name(name)
                       .email(name+"@gmail.com")
                       .build());
           });
       };
    }

}

package net.malick.ebankservice;

import net.malick.ebankservice.entities.BankAcount;
import net.malick.ebankservice.service.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EbankService ebankService) {
        return args -> {
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <=5; j++) {
                    ebankService.save(BankAcount.builder()
                            .type(Math.random()>=0.5?"CURRENT-ACCOUNT":"SAVAING-ACCOUNT")
                            .balance(1000+Math.random()*60000)
                            .customerId(i)
                            .build());
                }

            }
        };
    }

}

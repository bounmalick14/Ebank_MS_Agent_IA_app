package net.malick.ebankservice.service;

import net.malick.ebankservice.entities.BankAcount;
import net.malick.ebankservice.feign.CustomerRestClient;
import net.malick.ebankservice.model.Customer;
import net.malick.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public EbankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    public List<BankAcount> getAllBankAcount(){
        return bankAccountRepository.findAll();
    }

    public BankAcount getBankAccountById(String id){
        BankAcount bankAcount= bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Acount not found"));
        bankAcount.setCustomer(
                customerRestClient.getCustomerById(bankAcount.getCustomerId()));
        return bankAcount;
    }

    public BankAcount save(BankAcount bankAcount){
        try {
            Customer customer= customerRestClient.getCustomerById(bankAcount.getCustomerId());
            bankAcount.setId(UUID.randomUUID().toString());
            bankAcount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAcount);
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }

    }
}

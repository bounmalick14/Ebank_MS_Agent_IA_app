package net.malick.ebankservice.service;

import net.malick.ebankservice.entities.BankAcount;
import net.malick.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {

    private BankAccountRepository bankAccountRepository;

    public EbankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    public List<BankAcount> getAllBankAcount(){
        return bankAccountRepository.findAll();
    }

    public BankAcount getBankAccountById(String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Acount not found"));
    }

    public BankAcount save(BankAcount bankAcount){
        bankAcount.setId(UUID.randomUUID().toString());
        bankAcount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAcount);
    }
}

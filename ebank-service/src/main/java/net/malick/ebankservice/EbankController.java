package net.malick.ebankservice;

import net.malick.ebankservice.entities.BankAcount;
import net.malick.ebankservice.service.EbankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EbankController {

    private EbankService ebankService;

    public EbankController(EbankService ebankService) {
        this.ebankService = ebankService;
    }

    @GetMapping("/accounts")
    public List<BankAcount> getAllBankAcount(){
        return ebankService.getAllBankAcount();
    }

    @GetMapping("accounts/{id}")
    public BankAcount getBankAccountById(String id){
        return ebankService.getBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAcount save(BankAcount bankAcount){
        return ebankService.save(bankAcount);
    }
}

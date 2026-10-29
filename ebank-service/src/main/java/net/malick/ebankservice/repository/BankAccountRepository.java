package net.malick.ebankservice.repository;

import net.malick.ebankservice.entities.BankAcount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAcount, String> {

    List<BankAcount>  findByCustomerId(Long id);
}

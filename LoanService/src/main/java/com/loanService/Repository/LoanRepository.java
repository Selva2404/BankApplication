package com.loanService.Repository;

import com.loanService.Entity.Loan;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    Optional<Loan> findByMobileNumber(String mobileNumber);

    @Transactional
    @Modifying
    void deleteByMobileNumber(String mobileNumber);
}

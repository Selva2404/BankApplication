package com.loanService.service;

import com.loanService.DTO.LoanDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public interface ILoanService  {

     void createLoan(String loanDTO);

     LoanDTO findLoan(String mobileNumber);

     boolean updateLoan(LoanDTO loanDTO);

     void deleteLoan(@NotEmpty(message="mobile Number is null or empty") @Pattern(regexp="^[6-9]\\d{9,11}$") String mobileNumber);
}

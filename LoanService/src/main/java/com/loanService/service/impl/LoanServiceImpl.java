package com.loanService.service.impl;

import com.loanService.DTO.LoanDTO;
import com.loanService.Entity.Loan;
import com.loanService.Exception.CustomeException.LoanAvailableException;
import com.loanService.Exception.CustomeException.ResourceNotFoundException;
import com.loanService.Repository.LoanRepository;
import com.loanService.mapper.LoanMapper;
import com.loanService.service.ILoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {


    LoanRepository loanRepository;
    @Override
    public void createLoan(String loanDTO) {
        Loan loan = new Loan();
        loan.setMobileNumber(loanDTO);
        Optional<Loan> loanDetails=loanRepository.findByMobileNumber(loanDTO);
        if(loanDetails.isPresent()){
            throw new LoanAvailableException(" loan already exists for this user  " + loanDTO);
        }
        loanRepository.save(updateLoanDetails(loan));

    }
    private Loan updateLoanDetails(Loan loan) {

        Long loanNumber=10000000L+new Random().nextInt(9000000);
        loan.setLoanId(loanNumber);
        loan.setLoanAmount("100000");
        loan.setOutstandingAmount("100000");
        loan.setAmountPaid("0");
        loan.setLoanType("personal loan");
        return loan;
    }


    @Override
    public LoanDTO findLoan(String mobileNumber) {
        Loan loan=loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("loan","mobileNumber", mobileNumber)
        );
        log.debug("loan ="+loan);
        return LoanMapper.mapToLoanDTO(loan,new LoanDTO());
    }

    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        boolean isUpdated=false;
        if(loanDTO.getMobileNumber() != null) {
            Loan loan = loanRepository.findByMobileNumber(loanDTO.getMobileNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("loan", "mobileNumber", loanDTO.getMobileNumber())
            );
            log.debug("loan=>"+loan);
            LoanMapper.mapToLoan(loanDTO, loan);
            loanRepository.save(loan);
            isUpdated = true;
        }


    return isUpdated;
    }

    @Override
    public void deleteLoan(String mobileNumber) {
        loanRepository.deleteByMobileNumber(mobileNumber);
    }
}

package com.loanService.mapper;

import com.loanService.DTO.LoanDTO;
import com.loanService.Entity.Loan;

public class LoanMapper {
	
	public static LoanDTO mapToLoanDTO(Loan loan,LoanDTO loanDTO) {
		loanDTO.setAmountPaid(loan.getAmountPaid());
		loanDTO.setLoanAmount(loan.getLoanAmount());
		loanDTO.setOutstandingAmount(loan.getOutstandingAmount());
		loanDTO.setLoanType(loan.getLoanType());
		loanDTO.setMobileNumber(loan.getMobileNumber());
		loanDTO.setLoanId(loan.getLoanId());
		return loanDTO;
	}
	public static Loan mapToLoan(LoanDTO loanDTO,Loan loan){
		loan.setAmountPaid(loanDTO.getAmountPaid());
		loan.setLoanAmount(loanDTO.getLoanAmount());
		loan.setOutstandingAmount(loanDTO.getOutstandingAmount());
		loan.setLoanType(loanDTO.getLoanType());
		loan.setMobileNumber(loanDTO.getMobileNumber());
		loan.setLoanId(loanDTO.getLoanId());
		return loan;
	}

}

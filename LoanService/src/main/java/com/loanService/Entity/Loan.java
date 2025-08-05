package com.loanService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bankapp.Entity.CommonValue;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Loan extends CommonValue{
	
	@Id
	private Long loanId;

	@Column
	private String mobileNumber;
	
	@Column
	private String loanType;
	
	@Column
	private String LoanAmount;
	
	@Column
	private String amountPaid;
	
	@Column
	private String outstandingAmount;
	

}

package com.loanService.Exception.CustomeException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAvailableException extends RuntimeException {

    public LoanAvailableException(String msg) {
        super(msg);
    }
}

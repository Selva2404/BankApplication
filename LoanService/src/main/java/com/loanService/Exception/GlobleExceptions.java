package com.loanService.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.loanService.DTO.ErrorResponseDTO;
import com.loanService.Exception.CustomeException.LoanAvailableException;
import com.loanService.Exception.CustomeException.ResourceNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobleExceptions {

    @ExceptionHandler(LoanAvailableException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(LoanAvailableException exception, WebRequest request){

        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
         return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(ResourceNotFoundException exception, WebRequest request){

        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO(
                request.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception exception, WebRequest request){

        ErrorResponseDTO errorResponseDTO= new ErrorResponseDTO(
        		request.getDescription(false),
        		HttpStatus.INTERNAL_SERVER_ERROR,
        		exception.getMessage(),
        		LocalDateTime.now()
        		);
        return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

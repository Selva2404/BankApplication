package com.loanService.Exception.CustomeException;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource,String fieldName,String field){
        super(String.valueOf(" '/s' no resource found by "+resource+" "+fieldName+" "+field));
    }
}

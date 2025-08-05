package com.loanService.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "loans")
@Setter @Getter
public class LoanDtDTO {

    private String name;
    private Map<String,String> contact;
    private List<String> OnCall;
}

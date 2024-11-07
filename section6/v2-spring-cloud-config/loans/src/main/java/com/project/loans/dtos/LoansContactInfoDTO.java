package com.project.loans.dtos;

import com.project.loans.constants.LoansConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = LoansConstants.LOAN_CONFIG_PREFIX)
@Getter
@Setter
public class LoansContactInfoDTO {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}

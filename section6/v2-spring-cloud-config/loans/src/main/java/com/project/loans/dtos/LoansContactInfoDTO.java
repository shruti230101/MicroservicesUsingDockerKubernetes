package com.project.loans.dtos;

import com.project.loans.constants.LoansConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = LoansConstants.LOAN_CONFIG_PREFIX)
public record LoansContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}

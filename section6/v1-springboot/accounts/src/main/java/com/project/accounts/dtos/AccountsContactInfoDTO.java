package com.project.accounts.dtos;

import com.project.accounts.constants.AccountsConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = AccountsConstants.ACCOUNT_CONFIG_PREFIX)
public record AccountsContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}

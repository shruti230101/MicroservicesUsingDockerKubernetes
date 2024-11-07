package com.project.accounts.dtos;

import com.project.accounts.constants.AccountsConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = AccountsConstants.ACCOUNT_CONFIG_PREFIX)
@Getter
@Setter
public class AccountsContactInfoDTO {

    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}

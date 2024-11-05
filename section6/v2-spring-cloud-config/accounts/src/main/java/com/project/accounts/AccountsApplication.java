package com.project.accounts;

import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.constants.SwaggerConstants;
import com.project.accounts.dtos.AccountsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = AccountsConstants.ACCOUNT_AUDITOR_AWARE_REFERENCE)
@EnableConfigurationProperties(value = AccountsContactInfoDTO.class)
@OpenAPIDefinition(
		info = @Info(
				title = SwaggerConstants.ACCOUNTS_MS_TITLE,
				description = SwaggerConstants.ACCOUNTS_MS_DESCRIPTION,
				version = SwaggerConstants.ACCOUNTS_MS_VERSION,
				contact = @Contact(
						name = SwaggerConstants.ACCOUNTS_MS_CONTACT_NAME,
						email = SwaggerConstants.ACCOUNTS_MS_CONTACT_EMAIL,
						url = SwaggerConstants.ACCOUNTS_MS_CONTACT_URL
				),
				license = @License(
						name = SwaggerConstants.ACCOUNTS_MS_LICENCE_NAME,
						url = SwaggerConstants.ACCOUNTS_MS_CONTACT_URL
				)
		),
		externalDocs = @ExternalDocumentation(
				description = SwaggerConstants.ACCOUNTS_MS_DESCRIPTION,
				url = SwaggerConstants.ACCOUNTS_MS_EXTERNAL_DOCS_URL
		)
)
public class AccountsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
}

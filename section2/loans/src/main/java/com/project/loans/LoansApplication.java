package com.project.loans;

import com.project.loans.constants.LoansConstants;
import com.project.loans.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = LoansConstants.LOANS_AUDITOR_AWARE_REFERENCE)
@OpenAPIDefinition(
		info = @Info(
				title = SwaggerConstants.LOANS_MS_TITLE,
				description = SwaggerConstants.LOANS_MS_DESCRIPTION,
				version = SwaggerConstants.LOANS_MS_VERSION,
				contact = @Contact(
						name = SwaggerConstants.LOANS_MS_CONTACT_NAME,
						email = SwaggerConstants.LOANS_MS_CONTACT_EMAIL,
						url = SwaggerConstants.LOANS_MS_URL
				),
				license = @License(
						name = SwaggerConstants.LOANS_MS_LICENCE_NAME,
						url = SwaggerConstants.LOANS_MS_URL
				)
		),
		externalDocs = @ExternalDocumentation(
				description = SwaggerConstants.LOANS_MS_DESCRIPTION,
				url = SwaggerConstants.LOANS_MS_EXTERNAL_DOCS_URL
		)
)
public class LoansApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
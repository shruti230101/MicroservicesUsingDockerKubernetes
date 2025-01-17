package com.project.cards;

import com.project.cards.constants.SwaggerConstants;
import com.project.cards.dtos.CardsContactInfoDTO;
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
@EnableConfigurationProperties(value = {CardsContactInfoDTO.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = SwaggerConstants.CARDS_MS_TITLE,
				description = SwaggerConstants.CARDS_MS_DESCRIPTION,
				version = SwaggerConstants.CARDS_MS_VERSION,
				contact = @Contact(
						name = SwaggerConstants.CARDS_MS_CONTACT_NAME,
						email = SwaggerConstants.CARDS_MS_CONTACT_EMAIL,
						url = SwaggerConstants.CARDS_MS_CONTACT_URL
				),
				license = @License(
						name = SwaggerConstants.CARDS_MS_LICENCE_NAME,
						url = SwaggerConstants.CARDS_MS_LICENCE_URL
				)
		),
		externalDocs = @ExternalDocumentation(
				description = SwaggerConstants.CARDS_MS_DESCRIPTION,
				url = SwaggerConstants.CARDS_MS_EXTERNAL_DOCS_URL
		)
)
public class CardsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
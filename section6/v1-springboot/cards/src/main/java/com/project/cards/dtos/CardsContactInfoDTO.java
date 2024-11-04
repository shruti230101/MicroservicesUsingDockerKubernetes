package com.project.cards.dtos;

import com.project.cards.constants.CardsConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = CardsConstants.CARD_CONFIG_PREFIX)
public record CardsContactInfoDTO(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
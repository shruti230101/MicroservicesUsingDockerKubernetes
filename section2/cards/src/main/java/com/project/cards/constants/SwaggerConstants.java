package com.project.cards.constants;

public class SwaggerConstants {

    public static final String CARDS_MS_TAG_NAME = "CRUD REST APIs for Cards in Bank";
    public static final String CARDS_MS_TAG_DESCRIPTION = "CRUD REST APIs in Bank to CREATE, UPDATE, FETCH AND DELETE card details";

    public static final String CARDS_MS_TITLE = "Cards microservice REST API Documentation";
    public static final String CARDS_MS_DESCRIPTION = "Bank Cards microservice REST API Documentation";
    public static final String CARDS_MS_VERSION = "v1";
    public static final String CARDS_MS_CONTACT_NAME = "Shruti Agarwal";
    public static final String CARDS_MS_CONTACT_EMAIL = "shrutiagarwal@gmail.com";
    public static final String CARDS_MS_CONTACT_URL = "https://www.projectbanks.com";
    public static final String CARDS_MS_LICENCE_NAME = "Apache 2.0";
    public static final String CARDS_MS_LICENCE_URL = "https://www.projectbanks.com";
    public static final String CARDS_MS_EXTERNAL_DOCS_URL = "https://www.projectbanks.com/swagger-ui.html";

    public static final String CARDS_SCHEMA_NAME = "Cards";
    public static final String CARDS_SCHEMA_DESCRIPTION = "Schema to hold Card information";
    public static final String CARDS_SCHEMA_MOBILE_FIELD_DESCRIPTION = "Mobile Number of Customer";
    public static final String CARDS_SCHEMA_MOBILE_FIELD_EXAMPLE = "4354437687";
    public static final String CARDS_SCHEMA_CARD_NUMBER_FIELD_DESCRIPTION = "Card Number of the customer";
    public static final String CARDS_SCHEMA_CARD_NUMBER_FIELD_EXAMPLE = "100646930341";
    public static final String CARDS_SCHEMA_CARD_TYPE_FIELD_DESCRIPTION = "Type of the card";
    public static final String CARDS_SCHEMA_CARD_TYPE_FIELD_EXAMPLE = "Credit Card";
    public static final String CARDS_SCHEMA_TOTAL_LIMIT_FIELD_DESCRIPTION = "Total amount limit available against a card";
    public static final String CARDS_SCHEMA_TOTAL_LIMIT_FIELD_EXAMPLE = "10000";
    public static final String CARDS_SCHEMA_AMOUNT_USED_FIELD_DESCRIPTION = "Total amount used by a Customer";
    public static final String CARDS_SCHEMA_AMOUNT_USED_FIELD_EXAMPLE = "1000";
    public static final String CARDS_SCHEMA_AVAILABLE_AMOUNT_FIELD_DESCRIPTION = "Total available amount against a card";
    public static final String CARDS_SCHEMA_AVAILABLE_AMOUNT_FIELD_EXAMPLE = "9000";

    public static final String RESPONSE_SCHEMA_NAME = "Response";
    public static final String RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold successful response information";
    public static final String RESPONSE_SCHEMA_STATUS_CODE_FIELD_DESCRIPTION = "Status code of the response";
    public static final String RESPONSE_SCHEMA_STATUS_MESSAGE_FIELD_DESCRIPTION = "Status message of the response";

    public static final String ERROR_RESPONSE_SCHEMA_NAME = "Error Response";
    public static final String ERROR_RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold error response information";
    public static final String ERROR_RESPONSE_SCHEMA_API_PATH_FIELD_DESCRIPTION = "API path invoked by client";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_CODE_FIELD_DESCRIPTION = "Status code of the error response information";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_MESSAGE_FIELD_DESCRIPTION = "Error message representing the error happened";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_TIME_FIELD_DESCRIPTION = "Error time representing when the error happened";

    public static final String CREATE_CARD_API_SUMMARY = "Create Card REST API";
    public static final String CREATE_CARD_API_DESCRIPTION = "REST API to create new Card inside Bank";
    public static final String FETCH_CARD_API_SUMMARY = "Fetch Card Details REST API";
    public static final String FETCH_CARD_API_DESCRIPTION = "REST API to fetch card details based on a mobile number";
    public static final String UPDATE_CARD_API_SUMMARY = "Update Card Details REST API";
    public static final String UPDATE_CARD_API_DESCRIPTION = "REST API to update card details based on a card number";
    public static final String DELETE_CARD_API_SUMMARY = "Delete Card Details REST API";
    public static final String DELETE_CARD_API_DESCRIPTION = "REST API to delete Card details based on a mobile number";

    public static final String STATUS_200 = "200";
    public static final String STATUS_200_MESSAGE = "HTTP Status OK";
    public static final String STATUS_201 = "201";
    public static final String STATUS_201_MESSAGE = "HTTP Status CREATED";
    public static final String STATUS_417 = "417";
    public static final String STATUS_417_MESSAGE = "Expectation Failed";
    public static final String STATUS_500 = "500";
    public static final String STATUS_500_MESSAGE = "HTTP Status Internal Server Error";
}

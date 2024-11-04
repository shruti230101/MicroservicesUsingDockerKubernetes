package com.project.cards.constants;

public class CardsConstants {

    public static final String MOBILE_NUMBER_NOT_EMPTY = "Mobile Number can not be a null or empty";
    public static final String MOBILE_NUMBER_REGEX = "(^$|[0-9]{10})";
    public static final String MOBILE_NUMBER_LENGTH = "Mobile Number must be 10 digits";
    public static final String CARD_NUMBER_NOT_EMPTY = "Card Number can not be a null or empty";
    public static final String CARD_NUMBER_REGEX = "(^$|[0-9]{12})";
    public static final String CARD_NUMBER_LENGTH = "CardNumber must be 12 digits";
    public static final String CARD_TYPE_NOT_EMPTY = "CardType can not be a null or empty";
    public static final String CARD_LIMIT_VALIDATION = "Total card limit should be greater than zero";
    public static final String CARD_AMOUNT_USED_VALIDATION = "Total amount used should be equal or greater than zero";
    public static final String CARD_AMOUNT_AVAILABLE_VALIDATION = "Total available amount should be equal or greater than zero";

    public static final String  CREDIT_CARD = "Credit Card";
    public static final int  NEW_CARD_LIMIT = 1_00_000;
    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "Card updated successfully";
    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Card created successfully";
    public static final String  STATUS_417 = "417";
    public static final String  MESSAGE_417 = "Expectation failed";

    public static final String RESOURCE_NOT_FOUND_EXCEPTION_STRING_FORMAT = "%s not found with the given input data %s : '%s";
    public static final String CARD_ALREADY_EXISTS_EXCEPTION = "Card already registered with given mobileNumber ";
    public static final String CARD_RESOURCE_NAME = "Card";
    public static final String MOBILE_FIELD_NAME = "MobileNumber";
    public static final String CARD_NUMBER_FIELD_NAME = "Card Number";

    public static final String CARDS_BASIC_URL = "/api";
    public static final String CREATE_CARD_URL = "/create";
    public static final String FETCH_CARD_URL = "/fetch";
    public static final String UPDATE_CARD_URL = "/update";
    public static final String DELETE_CARD_URL = "/delete";
    public static final String BUILD_INFO = "/build-info";
    public static final String JAVA_VERSION = "/java-version";
    public static final String CONTACT_INFO = "/contact-info";

    public static final String CARDS_MOBILE_NUMBER_REGEX = "(^$|[0-9]{10})";
    public static final String CARDS_MOBILE_NUMBER_LENGTH = "Mobile Number must be 10 digits";
    public static final String ACCOUNT_VERSION_PROPERTY = "${build.version}";
    public static final String CARD_CONFIG_PREFIX = "cards";
    public static final String JAVA_VERSION_PROPERTY = "JAVA_HOME";
}

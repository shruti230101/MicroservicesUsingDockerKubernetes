package com.project.accounts.constants;

public class CardsConstants {

    public static final String CARDS_FEIGN_CLIENT = "cards";
    public static final String CARDS_DATA_FORMAT = "application/json";

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

    public static final String CARDS_BASIC_URL = "/api";
    public static final String FETCH_CARD_URL = "/fetch";
}

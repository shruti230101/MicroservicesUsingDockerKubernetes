package com.project.accounts.constants;

public class LoansConstants {

    public static final String LOANS_FEIGN_CLIENT = "loans";
    public static final String LOANS_DATA_FORMAT = "application/json";

    public static final String MOBILE_NUMBER_LENGTH = "Mobile Number must be 10 digits";
    public static final String MOBILE_NUMBER_NOT_EMPTY = "Mobile Number can not be a null or empty";
    public static final String MOBILE_NUMBER_REGEX = "(^$|[0-9]{10})";
    public static final String LOAN_NUMBER_NOT_EMPTY = "Loan Number can not be a null or empty";
    public static final String LOAN_TYPE_NOT_EMPTY = "Loan Number can not be a null or empty";
    public static final String TOTAL_LOAN_CONDITION = "Total loan amount should be greater than zero";
    public static final String LOAN_AMOUNT_PAID_CONDITION = "Amount paid should be greater than or equal to zero";
    public static final String TOTAL_OUTSTANDING_AMOUNT_CONDITION = "Total outstanding amount should be greater than or equal to zero";

    public static final String LOAN_BASE_PATH = "/api";
    public static final String FETCH_LOAN_URI = "/fetch";
}

package com.project.accounts.constants;

public class CustomerConstants {

    private CustomerConstants() {}

    public static final String CUSTOMER_NAME_NOT_EMPTY = "Customer name cannot be null or empty.";
    public static final int CUSTOMER_NAME_MIN_SIZE = 5;
    public static final int CUSTOMER_NAME_MAX_SIZE = 30;
    public static final String CUSTOMER_NAME_LENGTH = "The length of the customer name should be between 5 and 30.";
    public static final String CUSTOMER_EMAIL_NOT_EMPTY = "Customer email cannot be null or empty.";
    public static final String CUSTOMER_EMAIL_VALID = "Customer email should be a valid email address.";
    public static final String CUSTOMER_MOBILE_NUMBER_PATTERN = "(^$|[0-9]{10})";
    public static final String CUSTOMER_MOBILE_NUMBER_LENGTH = "Mobile number must be 10 digits";

    public static final String CUSTOMER_MOBILE_NUMBER_EXISTS = "Customer already registered with the given mobile number: ";

}
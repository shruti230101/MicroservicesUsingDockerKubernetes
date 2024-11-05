package com.project.loans.constants;

public class LoansConstants {

    public static final String MOBILE_NUMBER_LENGTH = "Mobile Number must be 10 digits";
    public static final String MOBILE_NUMBER_NOT_EMPTY = "Mobile Number can not be a null or empty";
    public static final String MOBILE_NUMBER_REGEX = "(^$|[0-9]{10})";
    public static final String LOAN_NUMBER_NOT_EMPTY = "Loan Number can not be a null or empty";
    public static final String LOAN_TYPE_NOT_EMPTY = "Loan Number can not be a null or empty";
    public static final String TOTAL_LOAN_CONDITION = "Total loan amount should be greater than zero";
    public static final String LOAN_AMOUNT_PAID_CONDITION = "Amount paid should be greater than or equal to zero";
    public static final String TOTAL_OUTSTANDING_AMOUNT_CONDITION = "Total outstanding amount should be greater than or equal to zero";
    public static final String  HOME_LOAN = "Home Loan";
    public static final int NEW_LOAN_LIMIT = 1_00_000;
    public static final String LOAN_RESOURCE = "Loan";
    public static final String LOAN_RESOURCE_MOBILE_FIELD = "Mobile number";
    public static final String LOAN_RESOURCE_LOAN_NUMBER_FIELD = "Loan number";

    public static final String LOAN_BASE_PATH = "/api";
    public static final String CREATE_LOAN_URI = "/create";
    public static final String FETCH_LOAN_URI = "/fetch";
    public static final String UPDATE_LOAN_URI = "/update";
    public static final String DELETE_LOAN_URI = "/delete";
    public static final String BUILD_INFO = "/build-info";
    public static final String JAVA_VERSION = "/java-version";
    public static final String CONTACT_INFO = "/contact-info";

    public static final String RESOURCE_NOT_FOUND_EXCEPTION = "%s not found with the given input data %s : '%s'";
    public static final String LOAN_ALREADY_EXISTS_EXCEPTION = "Loan already registered with given mobileNumber ";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Loan created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";

    public static final String LOAN_AUDIT_COMPONENT_NAME = "auditAwareImpl";
    public static final String LOANS_AUDIT = "Loans MS";
    public static final String LOANS_AUDITOR_AWARE_REFERENCE = "auditAwareImpl";
    public static final String ACCOUNT_VERSION_PROPERTY = "${build.version}";
    public static final String JAVA_VERSION_PROPERTY = "JAVA_HOME";
    public static final String LOAN_CONFIG_PREFIX = "loans";
}

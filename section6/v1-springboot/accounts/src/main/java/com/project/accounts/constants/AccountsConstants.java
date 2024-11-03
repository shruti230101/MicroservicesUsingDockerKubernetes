package com.project.accounts.constants;

public class AccountsConstants {

    private AccountsConstants() {}

    public static final String BASE_PATH = "/api";
    public static final String CREATE_ACCOUNT = "/create";
    public static final String FETCH_ACCOUNT = "/fetch";
    public static final String UPDATE_ACCOUNT = "/update";
    public static final String DELETE_ACCOUNT = "/delete";
    public static final String BUILD_INFO = "/build-info";
    public static final String JAVA_VERSION = "/java-version";
    public static final String CONTACT_INFO = "/contact-info";

    public static final String SAVINGS = "Savings";
    public static final String ADDRESS = "123 Main Street, New York";
    public static final String JAVA_VERSION_PROPERTY = "JAVA_HOME";

    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Account created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE = "Update operation failed. Please try again.";
    public static final String MESSAGE_417_DELETE = "Delete operation failed. Please try again.";

    public static final String ACCOUNT_NUMBER_NOT_EMPTY = "AccountNumber can not be a null or empty";
    public static final String ACCOUNT_TYPE_NOT_EMPTY = "AccountType can not be a null or empty";
    public static final String ACCOUNT_BRANCH_ADDRESS_NOT_EMPTY = "Account BranchAddress cannot be null or empty";
    public static final String ACCOUNT_NUMBER_PATTERN = "(^$|[0-9]{10})";
    public static final String ACCOUNT_NUMBER_LENGTH = "AccountNumber must be 10 digits";
    public static final String ACCOUNT_AUDITOR_AWARE_REFERENCE = "auditAwareImpl";
    public static final String ACCOUNT_VERSION_PROPERTY = "${build.version}";
    public static final String ACCOUNT_CONFIG_PREFIX = "accounts";
}

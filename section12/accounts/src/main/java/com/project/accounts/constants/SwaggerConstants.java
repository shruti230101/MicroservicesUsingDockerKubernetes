package com.project.accounts.constants;

public class SwaggerConstants {

    private SwaggerConstants(){}

    public static final String ACCOUNTS_MS_TAG_NAME = "CRUD APIs for Accounts microservice in Bank";
    public static final String ACCOUNTS_MS_TAG_DESCRIPTION = "CRUD APIs for Accounts in Bank to CREATE, FETCH, UPDATE and DELETE the details";
    public static final String CUSTOMER_CONTROLLER_TAG_NAME = "Rest APIs for customers in Bank";
    public static final String CUSTOMER_CONTROLLER_TAG_DESCRIPTION = "REST APIs in Bank to FETCH customer details";

    public static final String ACCOUNTS_MS_TITLE = "Accounts microservice REST API documentation";
    public static final String ACCOUNTS_MS_DESCRIPTION = "Bank Accounts microservice REST API documentation";
    public static final String ACCOUNTS_MS_VERSION = "v1";
    public static final String ACCOUNTS_MS_CONTACT_NAME = "Shruti Agarwal";
    public static final String ACCOUNTS_MS_CONTACT_EMAIL = "shrutiagarwal@gmail.com";
    public static final String ACCOUNTS_MS_CONTACT_URL = "https://www.projectbanks.com";
    public static final String ACCOUNTS_MS_LICENCE_NAME = "Apache 2.0";
    public static final String ACCOUNTS_MS_EXTERNAL_DOCS_URL = "https://www.projectbanks.com/swagger-ui.html";

    public static final String CREATE_ACCOUNT_SUMMARY = "Create Account REST API";
    public static final String CREATE_ACCOUNT_DESCRIPTION = "REST API to create new Customer and Account inside Bank";
    public static final String FETCH_ACCOUNT_SUMMARY = "Fetch Account Details REST API";
    public static final String FETCH_ACCOUNT_DESCRIPTION = "REST API to fetch Customer and Account details based on mobile number";
    public static final String UPDATE_ACCOUNT_SUMMARY = "Update Account REST API";
    public static final String UPDATE_ACCOUNT_DESCRIPTION = "REST API to update Customer and Account details based on mobile number";
    public static final String DELETE_ACCOUNT_SUMMARY = "Delete Account REST API";
    public static final String DELETE_ACCOUNT_DESCRIPTION = "REST API to delete Customer and Account details based on mobile number";
    public static final String BUILD_INFO_SUMMARY = "Get build information";
    public static final String BUILD_DESCRIPTION = "Get build information that is being deployed into accounts microservice";
    public static final String JAVA_VERSION_SUMMARY = "Get Java version";
    public static final String JAVA_VERSION_DESCRIPTION = "Get Java version details that is installed in the accounts microservices";
    public static final String CONTACT_INFO_SUMMARY = "Get contact info";
    public static final String CONTACT_INFO_DESCRIPTION = "Contact info details that can be reached out in case of any issues";

    public static final String CUSTOMER_SCHEMA_NAME = "Customer";
    public static final String CUSTOMER_SCHEMA_DESCRIPTION = "Schema to hold Customer and Account information";
    public static final String CUSTOMER_FIELD_NAME_DESCRIPTION = "Name of the customer";
    public static final String CUSTOMER_FIELD_NAME_EXAMPLE = "Shruti Agarwal";
    public static final String CUSTOMER_FIELD_EMAIL_DESCRIPTION = "Email of the customer";
    public static final String CUSTOMER_FIELD_EMAIL_EXAMPLE = "shrutiagarwal@gmail.com";
    public static final String CUSTOMER_FIELD_MOBILE_NUMBER_DESCRIPTION = "Mobile number of the customer";
    public static final String CUSTOMER_FIELD_MOBILE_NUMBER_EXAMPLE = "8108108109";
    public static final String CUSTOMER_FIELD_ACCOUNTS_DESCRIPTION = "Account details of the customer";
    public static final String CUSTOMER_FIELD_CARDS_DESCRIPTION = "Card details of the customer";
    public static final String CUSTOMER_FIELD_LOANS_DESCRIPTION = "Loan details of the customer";

    public static final String FETCH_CUSTOMER_DETAILS_SUMMARY = "Fetch Customer Details REST API";
    public static final String FETCH_CUSTOMER_DETAILS_DESCRIPTION = "REST API to fetch Customer details based on mobile number";

    public static final String ACCOUNTS_SCHEMA_NAME = "Accounts";
    public static final String ACCOUNTS_SCHEMA_DESCRIPTION = "Schema to hold the account details of the customer";
    public static final String ACCOUNTS_FIELD_ACCOUNT_NUMBER_DESCRIPTION = "Account number of the customer in the bank";
    public static final String ACCOUNTS_FIELD_ACCOUNT_NUMBER_EXAMPLE = "8108108109";
    public static final String ACCOUNTS_FIELD_ACCOUNT_TYPE_DESCRIPTION = "Account type of the customer in the bank";
    public static final String ACCOUNTS_FIELD_ACCOUNT_TYPE_EXAMPLE = "Savings";
    public static final String ACCOUNTS_FIELD_BRANCH_ADDRESS_DESCRIPTION = "Branch address of the bank";
    public static final String ACCOUNTS_FIELD_BRANCH_ADDRESS_EXAMPLE = "123, New York";

    public static final String CUSTOMER_DETAILS_SCHEMA_NAME = "CustomerDetails";
    public static final String CUSTOMER_DETAILS_SCHEMA_DESCRIPTION = "Schema to hold Customer, Account, Cards and Loans information";

    public static final String RESPONSE_SCHEMA_NAME = "Response";
    public static final String RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold successful response information";
    public static final String RESPONSE_STATUS_CODE_DESCRIPTION = "Status code of the response";
    public static final String RESPONSE_STATUS_MESSAGE_DESCRIPTION = "Status message of the response";

    public static final String ERROR_RESPONSE_SCHEMA_NAME = "Error Response";
    public static final String ERROR_RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold error response information";
    public static final String ERROR_RESPONSE_SCHEMA_API_PATH_DESCRIPTION = "API path invoked by the client";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_CODE_DESCRIPTION = "Error code representing the error happened";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_MESSAGE_DESCRIPTION = "Error message representing the error happened";
    public static final String ERROR_RESPONSE_SCHEMA_ERROR_TIME_DESCRIPTION = "Time representing when the error happened";

    public static final String STATUS_200 = "200";
    public static final String STATUS_200_MESSAGE = "HTTP Status OK";
    public static final String STATUS_201 = "201";
    public static final String STATUS_201_MESSAGE = "HTTP Status CREATED";
    public static final String STATUS_417 = "417";
    public static final String STATUS_417_MESSAGE = "Expectation Failed";
    public static final String STATUS_500 = "500";
    public static final String STATUS_500_MESSAGE = "HTTP Status Internal Server Error";

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

    public static final String LOAN_SCHEMA_NAME = "Loans";
    public static final String LOAN_SCHEMA_DESCRIPTION = "Schema to hold Loan information";
    public static final String LOAN_MOBILE_NUMBER_DESCRIPTION = "Mobile number of the customer";
    public static final String LOAN_MOBILE_NUMBER_EXAMPLE = "8108108109";
    public static final String LOAN_NUMBER_DESCRIPTION = "Loan number of the customer";
    public static final String LOAN_NUMBER_EXAMPLE = "548732457654";
    public static final String LOAN_TYPE_DESCRIPTION = "Type of the loan";
    public static final String LOAN_TYPE_EXAMPLE = "Home Loan";
    public static final String TOTAL_LOAN_AMOUNT_DESCRIPTION = "Total loan amount";
    public static final String TOTAL_LOAN_AMOUNT_EXAMPLE = "100000";
    public static final String LOAN_AMOUNT_PAID_DESCRIPTION = "Total loan amount paid";
    public static final String LOAN_AMOUNT_PAID_EXAMPLE = "10000";
    public static final String OUTSTANDING_AMOUNT_DESCRIPTION = "Total outstanding amount against a loan";
    public static final String OUTSTANDING_AMOUNT_EXAMPLE = "90000";
}
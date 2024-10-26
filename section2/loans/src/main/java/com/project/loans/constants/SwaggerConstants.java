package com.project.loans.constants;

public class SwaggerConstants {
    public static final String LOANS_MS_TITLE = "Loans microservice REST API Documentation";
    public static final String LOANS_MS_DESCRIPTION = "Bank Loans microservice REST API Documentation";
    public static final String LOANS_MS_VERSION = "v1";
    public static final String LOANS_MS_CONTACT_NAME = "Shruti Agarwal";
    public static final String LOANS_MS_CONTACT_EMAIL = "shrutiagarwal@gmail.com";
    public static final String LOANS_MS_URL = "https://www.projectbanks.com";
    public static final String LOANS_MS_LICENCE_NAME = "Apache 2.0";
    public static final String LOANS_MS_EXTERNAL_DOCS_URL = "https://www.eazybytes.com/swagger-ui.html";

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

    public static final String RESPONSE_SCHEMA_NAME = "Response";
    public static final String RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold successful response information";
    public static final String RESPONSE_STATUS_CODE_DESCRIPTION = "Status code of the response";
    public static final String RESPONSE_STATUS_MESSAGE_DESCRIPTION = "Status message of the response";

    public static final String ERROR_RESPONSE_SCHEMA_NAME = "ErrorResponse";
    public static final String ERROR_RESPONSE_SCHEMA_DESCRIPTION = "Schema to hold error response information";
    public static final String ERROR_RESPONSE_API_PATH_DESCRIPTION = "API path invoked by client";
    public static final String ERROR_RESPONSE_STATUS_CODE_DESCRIPTION = "Error code representing the error happened";
    public static final String ERROR_RESPONSE_STATUS_MESSAGE_DESCRIPTION = "Error message representing the error happened";
    public static final String ERROR_RESPONSE_ERROR_TIME_DESCRIPTION = "Error time representing when the error happened";

    public static final String STATUS_200 = "200";
    public static final String STATUS_200_MESSAGE = "Http Status OK";
    public static final String STATUS_201 = "201";
    public static final String STATUS_201_MESSAGE = "Http Status CREATED";
    public static final String STATUS_417 = "417";
    public static final String STATUS_417_MESSAGE = "Expectation Failed";
    public static final String STATUS_500 = "500";
    public static final String STATUS_500_MESSAGE = "Http Status Internal Server Error";

    public static final String LOANS_API_TAG_NAME = "CRUD REST APIs for Loans in Bank";
    public static final String LOANS_API_TAG_DESCRIPTION = "CRUD REST APIs in Bank to CREATE, UPDATE, FETCH AND DELETE loan details";
    public static final String CREATE_LOAN_SUMMARY = "Create Loan REST API";
    public static final String CREATE_LOAN_DESCRIPTION = "REST API to create new loan inside Bank";
    public static final String FETCH_LOAN_SUMMARY = "Fetch Loan details REST API";
    public static final String FETCH_LOAN_DESCRIPTION = "REST API to fetch loan details based on a mobile number";
    public static final String UPDATE_LOAN_SUMMARY = "Update Loan details REST API";
    public static final String UPDATE_LOAN_DESCRIPTION = "REST API to update loan details based on a loan number";
    public static final String DELETE_LOAN_SUMMARY = "Delete Loan REST API";
    public static final String DELETE_LOAN_DESCRIPTION = "REST API to delete loan details based on a mobile number";
}

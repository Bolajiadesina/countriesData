package com.bolaji.countriesData.models;

public enum ResponseEnum{
// TODO:
	// Work on API response messages
    SUCCESS("000", "Successful"),
    SUCCESS_FILE_UPLOAD("000", "Successful, your request will be updated in the background."),
    USER_CREATION_SUCCESS("000", "User creation Successful"),
    INVALID_HEADER_VALUES("200", "Invalid Header values provided"),
    RECORD_NOT_FOUND("201", "Record not found."),
    ERROR("900", "An Error occurred while processing request."),
    INVALID_REQUEST("999", "Invalid Request"),
    SERVICE_UNAVAILABLE("900", "Internal Middleware unavailable"),
	EMPTY_SENDER_OR_RECEIVER_NAME("400","Sender's or Receiver's Name Cannot be null"),
	API_PROCESSING_ERROR("500", "An Error occurred while processing request"),
	DB_RESPONSE_ERROR("500", "No appropriate response gotten from the database");

	
	private String message;
    private String code;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) { this.code = code; }

}
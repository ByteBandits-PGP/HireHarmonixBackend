package com.bytebandits.hireharmonics.dto.response;

public class GenericResponseDto {
    private String message;
    private Boolean success;

    public GenericResponseDto() {
    }

    public GenericResponseDto(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

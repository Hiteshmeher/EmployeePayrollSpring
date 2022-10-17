package com.bridgelabz.employeepayrollappspring.dto;

public class ResponseDTO {
    private String message;
    private Object data;

    //Constructors
    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

package com.SkyHire.project.Utility;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiErrorResponse {
    private HttpStatus status;
    private String message;
    private LocalDateTime timeStamp;


    public ApiErrorResponse(HttpStatus status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message=message;
        this.timeStamp=timeStamp;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

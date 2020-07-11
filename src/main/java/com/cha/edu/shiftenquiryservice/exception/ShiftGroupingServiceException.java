package com.cha.edu.shiftenquiryservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ShiftGroupingServiceException extends RuntimeException {

    public ShiftGroupingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.menes.be.demo.exception;

import com.menes.be.demo.utility.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.*;
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<?> handlerApiRequestException(ApiRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException eResponse = ApiException
                .builder()
                .message(e.getMessage())
                .status(badRequest)
                .time(DateFormatter.now())
                .build();
        return new ResponseEntity<>(eResponse, badRequest);
    }
}

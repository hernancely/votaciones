package com.ing3.votaciones.errorhandler;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author Luis.Luna
 * Date: 19/11/2021
 */
@ControllerAdvice
public class ErrorHandler {

    private Gson gson;

    @ExceptionHandler(value= {IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex, WebRequest request) {

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), ex.hashCode());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value= {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        var codigoError = HttpStatus.INTERNAL_SERVER_ERROR;
        Gson gson = new Gson();

        var err = ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), ex.hashCode());

        if(err.equals("No value present") ) codigoError = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), codigoError);
    }

}

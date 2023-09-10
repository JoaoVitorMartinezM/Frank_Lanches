package com.franklanches.exceptions;

import com.franklanches.dto.responses.ErrorResponse;
import com.gtbr.ViaCepClient;
import com.gtbr.exception.ViaCepException;
import com.gtbr.exception.ViaCepFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CepNotExistsException.class)
    public ResponseEntity<ErrorResponse> handleCepNotExistsException(CepNotExistsException ex) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "CEP inexistente", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler({ViaCepException.class})
    public ResponseEntity<ErrorResponse> handleViaCepException(ViaCepException ex){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "CEP com números faltantes", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler({ViaCepFormatException.class})
    public ResponseEntity<ErrorResponse> handleViaCepFormatException(ViaCepFormatException ex){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "CEP com formato inválido", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}

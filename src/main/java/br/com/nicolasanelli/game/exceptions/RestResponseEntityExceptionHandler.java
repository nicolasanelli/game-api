package br.com.nicolasanelli.game.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AuthorizationException.class)
    protected ResponseEntity<Object> handleAuthorizationException(HttpServletRequest request, AuthorizationException ex) {

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getError());
    }

    @ExceptionHandler(value = UnprocessableEntityException.class)
    protected ResponseEntity<Object> handleUnprocessableEntityException(HttpServletRequest request, UnprocessableEntityException ex) {

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getError());
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleIllegaState(HttpServletRequest request, Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}

package com.riwi.diagnostic.test.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.diagnostic.test.api.dto.errors.BaseErrorResponse;
import com.riwi.diagnostic.test.api.dto.errors.ErrorsResp;

import jakarta.ws.rs.BadRequestException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadResquestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseErrorResponse handleBadRequest(
      MethodArgumentNotValidException exception) {

    List<Map<String, String>> errors = new ArrayList<>();

    exception.getBindingResult().getFieldErrors().forEach(e -> {
      Map<String, String> error = new HashMap<>();
      error.put("error", e.getDefaultMessage());
      error.put("field", e.getField());
      errors.add(error);
    });

    return ErrorsResp.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();
  }

  @ExceptionHandler(BadRequestException.class)
  public BaseErrorResponse handleError(BadRequestException exception) {
    List<Map<String, String>> errors = new ArrayList<>();
    Map<String, String> error = new HashMap<>();

    error.put("id", exception.getMessage());

    errors.add(error);

    return ErrorsResp.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .errors(errors)
        .build();
  }
    
}

package com.restaurant.Restaurant.exceptions;

import com.restaurant.Restaurant.models.dto.errorDto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RestControllerAdvice
public class ExceptionHandlerAdvicer {

  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<ErrorDto> handlerValidationException(IllegalArgumentException e) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT.value())
        .body(ErrorDto
                .builder()
                .uuid(UUID.randomUUID().toString())
                .timeStamp(LocalDateTime.now().toString())
                .message(e.getMessage())
                .build());
  }
  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorDto> handlerGeneric(Exception e) {
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorDto
                    .builder()
                    .uuid(UUID.randomUUID().toString())
                    .timeStamp(LocalDateTime.now().toString())
                    .message("Error general del servidor: " + e.getMessage())
                    .build());
  }

}

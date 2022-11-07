package com.apirest.application.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String path;
    private String message;
    private Instant instant;
}

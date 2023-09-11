package com.franklanches.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private Instant timestamp = Instant.now();
    private int statusCode;
    private String error;
    private String message;
    private Map<String, String> details;

    public ErrorResponse(int statusCode, String error, String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }
}

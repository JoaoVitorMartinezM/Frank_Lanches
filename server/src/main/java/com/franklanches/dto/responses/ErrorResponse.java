package com.franklanches.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Instant timestamp = Instant.now();
    private int statusCode;
    private String error;
    private String message;
<<<<<<< HEAD
=======
    private Map<String, String> details;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544

    public ErrorResponse(int statusCode, String error, String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }
}

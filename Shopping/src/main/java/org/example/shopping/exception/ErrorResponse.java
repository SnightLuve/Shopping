package org.example.shopping.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private int status;
    private String error;
    private String path;
}

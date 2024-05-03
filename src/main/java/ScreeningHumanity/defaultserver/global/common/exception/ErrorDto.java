package ScreeningHumanity.defaultserver.global.common.exception;

import org.springframework.http.HttpStatus;

public class ErrorDto {
    private HttpStatus httpStatus;
    private int status;
    private String message;
}

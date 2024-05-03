package ScreeningHumanity.defaultserver.global.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDto> customException(CustomException e, WebRequest request){
        log.info("Message = {}", e.getBaseErrorCode().getMessage());
        log.info("HttpStatus = {}", e.getBaseErrorCode().getHttpStatus());
        log.info("Status = {}", e.getBaseErrorCode().getStatus());
        return null;
    }
}

package ScreeningHumanity.defaultserver.global.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BaseErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1000, "서버 에러 입니다");

    private final HttpStatus httpStatus;
    private final int status;
    private final String message;
}

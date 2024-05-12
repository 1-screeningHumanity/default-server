package ScreeningHumanity.defaultserver.global.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * 코드 내용
 * 성공 : 200
 * 유저 : 1000~1999
 *
 */
@Getter
@RequiredArgsConstructor
public enum BaseResponseCode {
    // Success
    SUCCESS(HttpStatus.OK, true,200, "요청 응답 성공."),

    //User
    //

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false,9000, "서버 에러 입니다");

    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private final String message;
}
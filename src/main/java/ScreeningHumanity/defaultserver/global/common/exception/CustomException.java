package ScreeningHumanity.defaultserver.global.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CustomException extends RuntimeException {

    private final BaseErrorCode baseErrorCode;
}

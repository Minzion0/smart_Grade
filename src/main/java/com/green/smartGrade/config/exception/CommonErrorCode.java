package com.green.smartGrade.config.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{
    ADMIN_EXCEPTION(HttpStatus.BAD_REQUEST, "에러 발생 : 개발자 이민용을 찾아주세요"),
    FIX_EXCEPTION(HttpStatus.NOT_FOUND, "에러 발생 : 관리자를 찾아주세요"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    ADMIN_PROFESSOR_ERROR(HttpStatus.NOT_EXTENDED,"계정등록 오류");

    private final HttpStatus httpStatus;
    private final String message;

}

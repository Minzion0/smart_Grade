package com.green.smartGrade.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class SmartGradeExceptionHandler extends ResponseEntityExceptionHandler {

    //401ExceptionHandler
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleClientErrorException(HttpServletRequest request){
        return handleExceptionInternal(CommonErrorCode.AUTHENTICATION_ERROR,CommonErrorCode.AUTHENTICATION_ERROR.getMessage(),request.getRequestURI());
    }
    //admin영역 ExceptionHandler
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<Object> handleAdminException(AdminException e, HttpServletRequest request){
        return handleAdminExceptionSet(CommonErrorCode.ADMIN_EXCEPTION, e.getMsg(),request.getRequestURI());
    }



    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException e,HttpServletRequest request) {
        log.warn("handleIllegalArgument", e);
        return handleExceptionInternal(CommonErrorCode.GLOBAL_EXCEPTION, e.getMessage(),request.getRequestURI());
    }

    //설정한것 이외의 모든 에러 처리
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex,HttpServletRequest request) {
        log.warn("handleAllException", ex);
        if (ex.getMessage().length()<30){

            return handleExceptionInternal(CommonErrorCode.GLOBAL_EXCEPTION, ex.getMessage(),request.getRequestURI());
        }
        return handleExceptionInternal(CommonErrorCode.GLOBAL_EXCEPTION,CommonErrorCode.GLOBAL_EXCEPTION.getMessage(),request.getRequestURI());
    }


    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ResponseEntity<Object> handleAdminExceptionSet(ErrorCode errorCode,String msg,String path){
        return ResponseEntity.status(errorCode.getHttpStatus()).body(makeErrorResponse(errorCode,msg,path));
    }

    // 에러 메시지 정리
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode) {
        return MyErrorResponse.builder()
                .code(errorCode.name())
                .dateTime(now())
                .message(CommonErrorCode.GLOBAL_EXCEPTION.getMessage())
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode, String message,String path) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode, message,path));
    }
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
        return MyErrorResponse.builder()
                .code(errorCode.name())
                .dateTime(now())
                .message(message)
                .build();
    }
    // 에러 메시지 정리
    private MyErrorResponse makeErrorResponse(ErrorCode errorCode, String message,String path) {
        return MyErrorResponse.builder()
                .code(errorCode.getMessage())
                .message(message)
                .path(path)
                .dateTime(now())
                .build();
    }

    // @Valid 어노테이션으로 넘어오는 에러 처리 메세지를 보내기 위한 메소드
    private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(e, errorCode));
    }

    // 에러 메시지 정리
    private MyErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode) {
        List<MyErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(MyErrorResponse.ValidationError::of)
                .collect(Collectors.toList());

        return MyErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .dateTime(now())
                .errors(validationErrorList)
                .build();
    }
    //에러 발생시간
    private String now(){
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss"));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd // HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}

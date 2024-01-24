package kg.aiylbank.aiylbanktask.exception.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import kg.aiylbank.aiylbanktask.exception.exceptionResponse.ExceptionResponse;
import kg.aiylbank.aiylbanktask.exception.exceptions.*;
import kg.aiylbank.aiylbanktask.exception.exceptions.BadCredentialException;
import kg.aiylbank.aiylbanktask.exception.exceptions.NotFoundException;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationFailException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse authenticationFail(AuthenticationFailException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(NotFoundException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse alreadyExist(AlreadyExistException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse methodArgumentNotValid(MethodArgumentNotValidException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage())
                .build();
    }


    @ExceptionHandler(BadCredentialException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionResponse badCredential(BadCredentialException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse badCredential(BadRequestException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MessageSendingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse messageSending(MessageSendingException exception){
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }
}

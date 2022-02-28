package by.liashuk.urlconverter.exception.controller;

import com.ruiyun.jvppeteer.exception.ProtocolException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("by.liashuk.urlconverter.rest")
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<ExceptionInfo> handleInterruptedException(InterruptedException exception) {
        ExceptionInfo info = new ExceptionInfo(exception.getMessage(), HttpStatus.BAD_REQUEST);
        log.warn("IN GlobalControllerAdvice handleInterruptedException() exception: {}", exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProtocolException.class)
    public ResponseEntity<ExceptionInfo> handleProtocolException(ProtocolException exception) {
        ExceptionInfo info = new ExceptionInfo(exception.getMessage(), HttpStatus.BAD_REQUEST);
        log.warn("IN GlobalControllerAdvice handleProtocolException() exception: {}", exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}

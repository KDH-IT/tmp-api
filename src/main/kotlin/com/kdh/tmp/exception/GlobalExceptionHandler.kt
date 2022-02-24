package com.kdh.tmp.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackages = ["com.kdh.tmp"])
class GlobalExceptionHandler {

    val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(ApiException::class)
    fun handleApiException(apiException: ApiException): ResponseEntity<Map<String, String>> {
        log.info("ApiException : {}", apiException.getResponseBody())
        return ResponseEntity(apiException.getResponseBody(), HttpStatus.valueOf(apiException.errorCode.statusCode))
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(exception: RuntimeException) {
        log.info("Unhandled RuntimeException", exception)
    }
}


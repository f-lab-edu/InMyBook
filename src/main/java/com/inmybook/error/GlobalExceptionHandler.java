package com.inmybook.error;

import java.nio.file.AccessDeniedException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.inmybook.application.service.exception.PostDeletionFailedException;
import com.inmybook.application.service.exception.PostModificationFailedException;
import com.inmybook.application.service.exception.PostRegistrationFailedException;
import com.inmybook.error.exception.PostNotFoundException;
import com.inmybook.error.exception.UnauthorizedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UnauthorizedException.class)
	protected ResponseEntity<ErrorResponseDto> handleUnauthorizedException(
		UnauthorizedException ex) {
		log.error("handleUnauthorizedException", ex);
		ErrorCode errorCode = ErrorCode.UNAUTHORIZED_ACCESS;
		return ErrorResponseDto.error(errorCode);
	}

	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ErrorResponseDto> handleAccessDeniedException(
		AccessDeniedException ex) {
		log.error("handleAccessDeniedException", ex);
		ErrorCode errorCode = ErrorCode.FORBIDDEN_ACCESS;
		return ErrorResponseDto.error(errorCode);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	protected ResponseEntity<ErrorResponseDto> handleNoHandlerFoundException(
		NoHandlerFoundException ex) {
		log.error("handleNoHandlerFoundException", ex);
		ErrorCode errorCode = ErrorCode.NOT_FOUND_HTTP_METHOD;
		return ErrorResponseDto.error(errorCode);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponseDto> handleHttpRequestMethodNotSupportedException(
		HttpRequestMethodNotSupportedException ex) {
		log.error("handleHttpRequestMethodNotSupportedException", ex);
		ErrorCode errorCode = ErrorCode.NOT_ALLOWED_HTTP_METHOD;
		return ErrorResponseDto.error(errorCode);
	}

	@ExceptionHandler(PostModificationFailedException.class)
	protected ResponseEntity<ErrorResponseDto> handlePostModificationFailedException(
		PostModificationFailedException ex) {
		log.error("handlePostModificationFailedException", ex);
		return ErrorResponseDto.error(ex.getErrorCode());
	}

	@ExceptionHandler(PostNotFoundException.class)
	protected ResponseEntity<ErrorResponseDto> handlePostNotFoundException(PostNotFoundException ex) {
		log.error("handlePostNotFoundException", ex);
		return ErrorResponseDto.error(ex.getErrorCode());
	}

	@ExceptionHandler(PostRegistrationFailedException.class)
	protected ResponseEntity<ErrorResponseDto> handlePostRegistrationFailedException(
		PostRegistrationFailedException ex) {
		log.error("handlePostRegistrationFailedException", ex);
		return ErrorResponseDto.error(ex.getErrorCode());
	}

	@ExceptionHandler(PostDeletionFailedException.class)
	protected ResponseEntity<ErrorResponseDto> handlePostDeletionFailedException(PostDeletionFailedException ex) {
		log.error("handlePostDeletionFailedException", ex);
		return ErrorResponseDto.error(ex.getErrorCode());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponseDto> handleAllException(Exception ex) {
		log.error("handleAllException", ex);
		ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
		return ErrorResponseDto.error(errorCode);
	}

}

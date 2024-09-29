package com.inmybook.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inmybook.application.service.exception.PostDeletionFailedException;
import com.inmybook.application.service.exception.PostModificationFailedException;
import com.inmybook.application.service.exception.PostRegistrationFailedException;
import com.inmybook.error.exception.PostNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

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

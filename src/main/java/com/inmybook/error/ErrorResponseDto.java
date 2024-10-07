package com.inmybook.error;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponseDto {
	public final int httpStatus;
	public final String code;
	public final String message;

	public ErrorResponseDto(ErrorCode errorCode) {
		this.httpStatus = errorCode.getHttpStatus().value();
		this.code = errorCode.name();
		this.message = errorCode.getMessage();
	}

	public static ResponseEntity<ErrorResponseDto> error(ErrorCode errorCode) {
		return ResponseEntity
			.status(errorCode.getHttpStatus())
			.body(ErrorResponseDto.builder()
				.httpStatus(errorCode.getHttpStatus().value())
				.code(errorCode.name())
				.message(errorCode.getMessage())
				.build());
	}
}

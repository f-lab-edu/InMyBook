package com.inmybook.error.exception;

import com.inmybook.error.ErrorCode;

import lombok.Getter;

@Getter
public class InMyBookException extends RuntimeException {
	// ErrorCode가 HttpStatus, message를 가짐으로써 에러 변경 범위 최소화
	private final ErrorCode errorCode;

	public InMyBookException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}

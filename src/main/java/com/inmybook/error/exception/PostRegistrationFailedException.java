package com.inmybook.error.exception;

import com.inmybook.error.ErrorCode;

import lombok.Getter;

@Getter
public class PostRegistrationFailedException extends InMyBookException {
	public PostRegistrationFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

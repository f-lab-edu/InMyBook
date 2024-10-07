package com.inmybook.application.service.exception;

import com.inmybook.error.ErrorCode;
import com.inmybook.error.exception.InMyBookException;

import lombok.Getter;

@Getter
public class PostRegistrationFailedException extends InMyBookException {
	public PostRegistrationFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

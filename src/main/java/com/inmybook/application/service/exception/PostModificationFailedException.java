package com.inmybook.application.service.exception;

import com.inmybook.error.ErrorCode;
import com.inmybook.error.exception.InMyBookException;

import lombok.Getter;

@Getter
public class PostModificationFailedException extends InMyBookException {
	public PostModificationFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

package com.inmybook.application.service.exception;

import com.inmybook.error.ErrorCode;
import com.inmybook.error.exception.InMyBookException;

import lombok.Getter;

@Getter
public class PostDeletionFailedException extends InMyBookException {
	public PostDeletionFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

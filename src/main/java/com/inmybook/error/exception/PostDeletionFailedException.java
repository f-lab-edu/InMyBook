package com.inmybook.error.exception;

import com.inmybook.error.ErrorCode;

import lombok.Getter;

@Getter
public class PostDeletionFailedException extends InMyBookException {
	public PostDeletionFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

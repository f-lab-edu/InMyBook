package com.inmybook.error.exception;

import com.inmybook.error.ErrorCode;

import lombok.Getter;

@Getter
public class PostModificationFailedException extends InMyBookException {
	public PostModificationFailedException(ErrorCode errorCode) {
		super(errorCode);
	}
}

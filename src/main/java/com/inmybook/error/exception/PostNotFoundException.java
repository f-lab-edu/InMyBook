package com.inmybook.error.exception;

import com.inmybook.error.ErrorCode;

import lombok.Getter;

@Getter
public class PostNotFoundException extends InMyBookException {
	public PostNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}

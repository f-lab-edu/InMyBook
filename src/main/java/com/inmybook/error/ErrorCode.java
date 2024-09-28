package com.inmybook.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생하였습니다."),

	POST_NOT_FOUND(HttpStatus.NOT_FOUND, "독서록 정보가 존재하지 않습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}

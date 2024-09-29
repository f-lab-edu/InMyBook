package com.inmybook.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	INVALID_REQUIRED_PARAMETER(HttpStatus.BAD_REQUEST, "필수 파라미터가 존재하지 않습니다."),
	NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생하였습니다. 다시 시도해주세요."),

	POST_NOT_FOUND(HttpStatus.NOT_FOUND, "독서록 정보가 존재하지 않습니다."),
	POST_REGISTRATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "독서록 등록 중 문제가 발생했습니다. 다시 시도해주세요."),
	POST_MODIFICATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "독서록 수정 중 문제가 발생했습니다. 다시 시도해주세요."),
	POST_DELETION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "독서록 삭제 중 문제가 발생했습니다. 다시 시도해주세요."),

	FILE_READ_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "파일 읽기 작업 중 문제가 발생했습니다. 다시 시도해주세요.");

	private final HttpStatus httpStatus;
	private final String message;
}

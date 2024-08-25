package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record MemberResponse(
	Long memberNo,
	String memberId,
	String nickname
) {
}

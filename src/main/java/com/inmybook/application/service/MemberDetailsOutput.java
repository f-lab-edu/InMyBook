package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record MemberDetailsOutput(
	Long memberNo,
	String memberId,
	String nickname
) {
}

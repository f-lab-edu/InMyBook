package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record MemberDetailsOutput(
	String memberId,
	String nickname
) {
}

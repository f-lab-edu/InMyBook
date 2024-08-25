package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record PostResponse(
	ContentResponse contentResponse,
	MemberResponse memberResponse
) {
}

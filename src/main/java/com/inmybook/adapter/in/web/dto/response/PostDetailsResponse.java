package com.inmybook.adapter.in.web.dto.response;

public record PostDetailsResponse(
	String postId,
	ContentResponse contentResponse,
	MemberResponse memberResponse
) {
}

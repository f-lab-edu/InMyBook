package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record PostDetailsOutput(
	String postId,
	ContentDetailsOutput contentDetailsOutput,
	MemberDetailsOutput memberDetailsOutput
) {
}

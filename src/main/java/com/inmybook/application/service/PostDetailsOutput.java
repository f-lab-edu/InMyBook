package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record PostDetailsOutput(
	ContentDetailsOutput contentDetailsOutput,
	MemberDetailsOutput memberDetailsOutput
) {
}

package com.inmybook.adapter.in.web.dto;

import lombok.Builder;

@Builder
public record RegisterPostInput(
	BookRequest book,
	ContentRequest content,
	MemberRequest member
) {
}

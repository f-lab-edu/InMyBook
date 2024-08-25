package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record ContentResponse(
	String title,
	String content,
	String fromDate,
	String toDate,
	double rating,
	int likeCount,
	int bookmarkCount,
	String isPublic,
	String uuid
) {
}

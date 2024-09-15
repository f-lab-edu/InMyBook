package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record ContentDetailsOutput(
	String title,
	String content,
	String readingStartDate,
	String readingEndDate,
	double rating,
	int likeCount,
	int bookmarkCount,
	String isPublic
) {
}

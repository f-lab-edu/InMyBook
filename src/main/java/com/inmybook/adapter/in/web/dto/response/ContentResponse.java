package com.inmybook.adapter.in.web.dto.response;

public record ContentResponse(
	String title,
	String content,
	String fromDate,
	String toDate,
	double rating,
	int likeCount,
	int bookmarkCount,
	String isPublic
) {
}

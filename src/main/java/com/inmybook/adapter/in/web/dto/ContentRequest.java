package com.inmybook.adapter.in.web.dto;

public record ContentRequest(
	String title,
	String content,
	String readingStartDate,
	String readingEndDate,
	double rating,
	String isPublic
) {
}

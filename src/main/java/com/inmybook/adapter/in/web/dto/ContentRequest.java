package com.inmybook.adapter.in.web.dto;

public record ContentRequest(
	String title,
	String content,
	String fromDate,
	String toDate,
	double rating,
	String isPublic
) {
}

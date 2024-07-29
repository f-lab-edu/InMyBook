package com.inmybook.adapter.in.web.dto;

public record ContentDto(
	String isbnNo,
	String bookName,
	String author,
	String publisher,
	ThumbnailDto thumbnailDto,
	String title,
	String content,
	double rating,
	int likeCount,
	int bookmarkCount,
	String isPublic
) {
}

package com.inmybook.adapter.in.web.dto;

import lombok.Builder;

@Builder
public record RegisterPostInputDto(
	String isbnNo,
	String bookName,
	String author,
	String publisher,
	String title,
	String content,
	String fromDate,
	String toDate,
	double rating,
	int likeCount,
	int bookmarkCount,
	String isPublic,
	String memberId,
	String thumbnailName,
	Long thumbnailSize,
	String thumbnailExt,
	byte[] thumbnailData
) {
}

package com.inmybook.application.port.in;

import lombok.Builder;

@Builder
public record RegistPostCommand(
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

package com.inmybook.application.port.in;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RegisterPostCommand(
	@NotNull
	String isbnNo,
	@NotNull
	String bookName,
	String author,
	String publisher,
	@NotNull
	String title,
	String content,
	String readingStartDate,
	String readingEndDate,
	double rating,
	String isPublic,
	@NotNull
	String memberId,
	MultipartFile thumbnailImg
) {
}

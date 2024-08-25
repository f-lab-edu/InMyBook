package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record BookResponse(
	String isbnNo,
	String bookName,
	String author,
	String publisher
) {
}

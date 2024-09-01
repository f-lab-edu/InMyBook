package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record BookDetailsOutput(
	String isbnNo,
	String bookName,
	String author,
	String publisher
) {
}

package com.inmybook.adapter.in.web.dto.response;

public record BookResponse(
	String isbnNo,
	String bookName,
	String author,
	String publisher
) {
}

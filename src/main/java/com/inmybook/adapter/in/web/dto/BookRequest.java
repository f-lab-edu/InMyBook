package com.inmybook.adapter.in.web.dto;

public record BookRequest(
	String isbnNo,
	String bookName,
	String author,
	String publisher
) {
}

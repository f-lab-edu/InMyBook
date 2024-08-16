package com.inmybook.domain.post;

import lombok.Builder;

@Builder
public class Book {
	private int bookId;
	private String isbnNo;
	private String bookName;
	private String author;
	private String publisher;
	private Thumbnail thumbnail;
}

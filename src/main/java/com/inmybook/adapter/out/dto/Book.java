package com.inmybook.adapter.out.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long id;
	private String isbnNo;
	private String bookName;
	private String bookDetails;
	private String author;
	private String publisher;
	private String bookThumbUrl;

	@OneToOne(mappedBy = "book")
	private Attach attach;

	@Builder
	public Book(String isbnNo, String bookName, String bookDetails, String author, String publisher,
		String bookThumbUrl, Attach attach) {
		this.isbnNo = isbnNo;
		this.bookName = bookName;
		this.bookDetails = bookDetails;
		this.author = author;
		this.publisher = publisher;
		this.bookThumbUrl = bookThumbUrl;
		this.attach = attach;
	}
}

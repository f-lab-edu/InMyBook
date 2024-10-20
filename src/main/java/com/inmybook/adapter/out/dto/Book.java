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
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
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

	@OneToOne(mappedBy = "attach")
	private Attach attach;

	@Builder
	public Book(String isbnNo, String bookName, String bookDetails, String author, String publisher,
		String bookThumbUrl, Attach attach) {
		Book book = new Book();
		book.setIsbnNo(isbnNo);
		book.setBookName(bookName);
		book.setBookDetails(bookDetails);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setBookThumbUrl(bookThumbUrl);
		book.setAttach(attach);
	}
}

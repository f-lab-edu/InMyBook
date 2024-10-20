package com.inmybook.adapter.out.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	private String title;
	private String content;
	private String readingState;
	private LocalDateTime readingStartDate;
	private LocalDateTime readingEndDate;
	private double rating;
	private String publicYn;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;
	private String postUuid;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@Builder
	public Post(String title, String content, String readingState, LocalDateTime readingStartDate,
		LocalDateTime readingEndDate, double rating, String publicYn, String postUuid, Book book,
		Member member) {
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setReadingState(readingState);
		post.setReadingStartDate(readingStartDate);
		post.setReadingEndDate(readingEndDate);
		post.setRating(rating);
		post.setPublicYn(publicYn);
		post.setRegistDate(LocalDateTime.now());
		post.setPostUuid(postUuid);
		post.setBook(book);
		post.setMember(member);
	}
}

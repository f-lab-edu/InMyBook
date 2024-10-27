package com.inmybook.adapter.out.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	private String title;
	private String content;

	@Enumerated(EnumType.STRING)
	private ReadingState readingState;
	private LocalDateTime readingStartDate;
	private LocalDateTime readingEndDate;
	private BigDecimal rating;
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

	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	@OneToMany(mappedBy = "post")
	private List<Bookmark> bookmarks;

	@OneToMany(mappedBy = "post")
	private List<Like> likes;

	@Builder
	public Post(String title, String content, ReadingState readingState, LocalDateTime readingStartDate,
		LocalDateTime readingEndDate, BigDecimal rating, String publicYn, LocalDateTime registDate,
		LocalDateTime updateDate,
		String postUuid, Book book, Member member, List<Comment> comments, List<Bookmark> bookmarks, List<Like> likes) {
		this.title = title;
		this.content = content;
		this.readingState = readingState;
		this.readingStartDate = readingStartDate;
		this.readingEndDate = readingEndDate;
		this.rating = rating;
		this.publicYn = publicYn;
		this.registDate = registDate;
		this.updateDate = updateDate;
		this.postUuid = postUuid;
		this.book = book;
		this.member = member;
		this.comments = comments;
		this.bookmarks = bookmarks;
		this.likes = likes;
	}
}

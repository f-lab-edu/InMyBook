package com.inmybook.adapter.out.dto;

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
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "POST")
@Entity
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	private Long id;
	private String title;
	private String content;

	@Enumerated(EnumType.STRING)
	private ReadingState readingState;
	private LocalDateTime readingStartDate;
	private LocalDateTime readingEndDate;
	private double rating;
	private String publicYn;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;
	private String postUuid;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ID")
	private BookEntity book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private MemberEntity member;

	@OneToMany(mappedBy = "post")
	private List<CommentEntity> comments;

	@OneToMany(mappedBy = "post")
	private List<BookmarkEntity> bookmarks;

	@OneToMany(mappedBy = "post")
	private List<LikeEntity> likes;

	@Builder
	public PostEntity(String title, String content, ReadingState readingState, LocalDateTime readingStartDate,
		LocalDateTime readingEndDate, double rating, String publicYn, LocalDateTime registDate,
		LocalDateTime updateDate,
		String postUuid, BookEntity book, MemberEntity member, List<CommentEntity> comments,
		List<BookmarkEntity> bookmarks, List<LikeEntity> likes) {
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

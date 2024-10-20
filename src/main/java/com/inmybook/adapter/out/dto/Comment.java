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
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long id;
	private String commentContent;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;
	private int depth;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_comment_id")
	private Comment parentCommentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@Builder
	public Comment(String commentContent, LocalDateTime registDate, LocalDateTime updateDate, int depth,
		Comment parentCommentId, Post post, Member member) {
		this.commentContent = commentContent;
		this.registDate = LocalDateTime.now();
		this.depth = depth;
		this.parentCommentId = parentCommentId;
		this.post = post;
		this.member = member;
	}
}

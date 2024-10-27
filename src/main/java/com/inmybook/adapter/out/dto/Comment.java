package com.inmybook.adapter.out.dto;

import static jakarta.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
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

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_comment_id")
	private Comment parentComment;

	@OneToMany(mappedBy = "parentComment")
	private List<Comment> childrenComments;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "commenter_id")
	private Member member;

	@Builder
	public Comment(String commentContent, LocalDateTime registDate, LocalDateTime updateDate, int depth,
		Comment parentComment, Post post, Member member) {
		this.commentContent = commentContent;
		this.registDate = LocalDateTime.now();
		this.depth = depth;
		this.parentComment = parentComment;
		this.post = post;
		this.member = member;
	}
}

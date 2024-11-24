package com.inmybook.adapter.out.dto;

import static jakarta.persistence.FetchType.LAZY;

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
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "COMMENT")
@Entity
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMENT_ID")
	private Long id;
	private String commentContent;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;
	private int depth;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "PARENT_COMMENT_ID")
	private CommentEntity parentComment;

	@OneToMany(mappedBy = "parentComment")
	private List<CommentEntity> childrenComments;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "POST_ID")
	private PostEntity post;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "COMMENTER_ID")
	private MemberEntity member;

	@Builder
	public CommentEntity(String commentContent, LocalDateTime registDate, LocalDateTime updateDate, int depth,
		CommentEntity parentComment, PostEntity post, MemberEntity member) {
		this.commentContent = commentContent;
		this.registDate = LocalDateTime.now();
		this.depth = depth;
		this.parentComment = parentComment;
		this.post = post;
		this.member = member;
	}
}

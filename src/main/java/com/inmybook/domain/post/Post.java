package com.inmybook.domain.post;

import com.inmybook.domain.member.Member;

import lombok.Builder;

@Builder
public class Post {
	private Long postId;
	private Book book;
	private Content content;
	private Thumbnail thumbnail;
	private Member member;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String createPostPath(Long id) {
		String path = "/post/" + id;
		return path;
	}
}

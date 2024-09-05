package com.inmybook.domain.post;

import com.inmybook.domain.member.Member;

import lombok.Builder;

@Builder
public class Post {
	private String postId;
	private Book book;
	private Content content;
	private Thumbnail thumbnail;
	private Member member;

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String createPostPath(String id) {
		return "/posts/" + id;
	}
}

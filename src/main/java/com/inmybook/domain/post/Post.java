package com.inmybook.domain.post;

import com.inmybook.domain.member.Member;

import lombok.Builder;

@Builder
public class Post {
	private int postId;
	private Book book;
	private Content content;
	private Thumbnail thumbnail;
	private Member member;

	public String createPostPath(int id) {
		String path = "/post/" + id;
		return path;
	}
}

package com.inmybook.domain.post;

import com.inmybook.application.port.in.RegisterPostCommand;

public class PostFactory {
	public Post createPost(RegisterPostCommand registerPostCommand) {
		Post post = Post.builder()
			.isbnNo(registerPostCommand.isbnNo())
			.bookName(registerPostCommand.bookName())
			.author(registerPostCommand.author())
			.publisher(registerPostCommand.publisher())
			.title(registerPostCommand.title())
			.content(registerPostCommand.content())
			.fromDate(registerPostCommand.fromDate())
			.toDate(registerPostCommand.toDate())
			.rating(registerPostCommand.rating())
			.likeCount(registerPostCommand.likeCount())
			.bookmarkCount(registerPostCommand.bookmarkCount())
			.isPublic(registerPostCommand.isPublic())
			.memberId(registerPostCommand.memberId())
			.thumbnailName(registerPostCommand.thumbnailName())
			.thumbnailSize(registerPostCommand.thumbnailSize())
			.thumbnailExt(registerPostCommand.thumbnailExt())
			.thumbnailData(registerPostCommand.thumbnailData())
			.build();

		return post;
	}
}

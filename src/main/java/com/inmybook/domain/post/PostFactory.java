package com.inmybook.domain.post;

import com.inmybook.application.port.in.RegistPostCommand;

public class PostFactory {
	public Post createPost(RegistPostCommand registPostCommand) {
		Post post = Post.builder()
			.isbnNo(registPostCommand.isbnNo())
			.bookName(registPostCommand.bookName())
			.author(registPostCommand.author())
			.publisher(registPostCommand.publisher())
			.title(registPostCommand.title())
			.content(registPostCommand.content())
			.rating(registPostCommand.rating())
			.likeCount(registPostCommand.likeCount())
			.bookmarkCount(registPostCommand.bookmarkCount())
			.isPublic(registPostCommand.isPublic())
			.memberId(registPostCommand.memberId())
			.thumbnailName(registPostCommand.thumbnailName())
			.thumbnailSize(registPostCommand.thumbnailSize())
			.thumbnailExt(registPostCommand.thumbnailExt())
			.thumbnailData(registPostCommand.thumbnailData())
			.build();

		return post;
	}
}

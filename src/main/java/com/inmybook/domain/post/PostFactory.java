package com.inmybook.domain.post;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.domain.member.Member;

@Component
public class PostFactory {
	public Post createPost(RegisterPostCommand registerPostCommand) throws IOException {
		Thumbnail thumbnail = new Thumbnail();
		if (registerPostCommand.thumbnailImg() != null) {
			thumbnail = new Thumbnail(registerPostCommand.thumbnailImg().getName()
				, registerPostCommand.thumbnailImg().getContentType()
				, registerPostCommand.thumbnailImg().getSize()
				, registerPostCommand.thumbnailImg().getBytes());
		}

		Book book = Book.builder()
			.isbnNo(registerPostCommand.isbnNo())
			.bookName(registerPostCommand.bookName())
			.author(registerPostCommand.author())
			.publisher(registerPostCommand.publisher())
			.thumbnail(thumbnail)
			.build();

		Content content = Content.builder()
			.title(registerPostCommand.title())
			.content(registerPostCommand.content())
			.fromDate(registerPostCommand.fromDate())
			.toDate(registerPostCommand.toDate())
			.rating(registerPostCommand.rating())
			.likeCount(0)
			.bookmarkCount(0)
			.isPublic(registerPostCommand.isPublic())
			.build();

		Member member = Member.builder()
			.memberId(registerPostCommand.memberId())
			.build();

		Post post = Post.builder()
			.book(book)
			.content(content)
			.member(member)
			.build();

		return post;
	}
}

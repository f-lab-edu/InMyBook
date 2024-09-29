package com.inmybook.domain.post;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.service.exception.PostRegistrationFailedException;
import com.inmybook.domain.member.Member;
import com.inmybook.error.ErrorCode;

@Component
public class PostFactory {
	public Post createPost(RegisterPostCommand registerPostCommand) {
		Thumbnail thumbnail = new Thumbnail();
		if (registerPostCommand.thumbnailImg() != null) {
			try {
				thumbnail = new Thumbnail(registerPostCommand.thumbnailImg().getName()
					, registerPostCommand.thumbnailImg().getContentType()
					, registerPostCommand.thumbnailImg().getSize()
					, registerPostCommand.thumbnailImg().getBytes());
			} catch (IOException e) {
				// throw new RuntimeException("독서록 게시글을 등록할 수 없습니다.");
				throw new PostRegistrationFailedException(ErrorCode.INVALID_PARAMETER);
			}
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
			.readingStartDate(registerPostCommand.readingStartDate())
			.readingEndDate(registerPostCommand.readingEndDate())
			.rating(registerPostCommand.rating())
			.likeCount(0)
			.bookmarkCount(0)
			.isPublic(registerPostCommand.isPublic())
			.build();

		Member member = Member.builder()
			.memberId(registerPostCommand.memberId())
			.build();

		Post post = Post.builder()
			.postId(getUuid())
			.book(book)
			.content(content)
			.member(member)
			.build();

		return post;
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}

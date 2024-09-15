package com.inmybook.adapter.in.web.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.inmybook.application.port.in.RegisterPostCommand;

@Component
public class PostMapper {
	public RegisterPostCommand createRegisterPostCommand(RegisterPostInput registerPostInput,
		MultipartFile multipartFile) {
		RegisterPostCommand registerPostCommand = RegisterPostCommand.builder()
			.isbnNo(registerPostInput.book().isbnNo())
			.bookName(registerPostInput.book().bookName())
			.author(registerPostInput.book().author())
			.publisher(registerPostInput.book().publisher())
			.title(registerPostInput.content().title())
			.content(registerPostInput.content().content())
			.readingStartDate(registerPostInput.content().readingStartDate())
			.readingEndDate(registerPostInput.content().readingEndDate())
			.rating(registerPostInput.content().rating())
			.isPublic(registerPostInput.content().isPublic())
			.memberId(registerPostInput.member().memberId())
			.thumbnailImg(multipartFile)
			.build();

		return registerPostCommand;
	}
}

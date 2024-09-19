package com.inmybook.adapter.in.web.dto;

import org.springframework.web.multipart.MultipartFile;

import com.inmybook.adapter.in.web.dto.response.ContentResponse;
import com.inmybook.adapter.in.web.dto.response.MemberResponse;
import com.inmybook.adapter.in.web.dto.response.PostDetailsResponse;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.service.PostDetailsOutput;

public class PostMapper {
	public static RegisterPostCommand createRegisterPostCommand(RegisterPostInput registerPostInput,
		MultipartFile multipartFile) {

		return RegisterPostCommand.builder()
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
	}

	public static PostDetailsResponse createReadPostDetailsResponse(PostDetailsOutput postDetailsOutput) {
		ContentResponse contentResponse = new ContentResponse(
			postDetailsOutput.contentDetailsOutput().title(),
			postDetailsOutput.contentDetailsOutput().content(),
			postDetailsOutput.contentDetailsOutput().readingStartDate(),
			postDetailsOutput.contentDetailsOutput().readingEndDate(),
			postDetailsOutput.contentDetailsOutput().rating(),
			postDetailsOutput.contentDetailsOutput().likeCount(),
			postDetailsOutput.contentDetailsOutput().bookmarkCount(),
			postDetailsOutput.contentDetailsOutput().isPublic()
		);

		MemberResponse memberResponse = new MemberResponse(
			postDetailsOutput.memberDetailsOutput().memberId(),
			postDetailsOutput.memberDetailsOutput().nickname()
		);

		return new PostDetailsResponse(
			postDetailsOutput.postId(),
			contentResponse,
			memberResponse
		);
	}
}

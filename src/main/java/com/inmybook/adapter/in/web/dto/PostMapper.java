package com.inmybook.adapter.in.web.dto;

import org.springframework.web.multipart.MultipartFile;

import com.inmybook.adapter.in.web.dto.response.ContentResponse;
import com.inmybook.adapter.in.web.dto.response.MemberResponse;
import com.inmybook.adapter.in.web.dto.response.PostDetailsResponse;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.service.PostDetailsOutput;

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
			.fromDate(registerPostInput.content().fromDate())
			.toDate(registerPostInput.content().toDate())
			.rating(registerPostInput.content().rating())
			.isPublic(registerPostInput.content().isPublic())
			.memberId(registerPostInput.member().memberId())
			.thumbnailImg(multipartFile)
			.build();

		return registerPostCommand;
	}

	public PostDetailsResponse createReadPostDetailsResponse(PostDetailsOutput postDetailsOutput) {
		ContentResponse contentResponse = new ContentResponse(
			postDetailsOutput.contentDetailsOutput().title(),
			postDetailsOutput.contentDetailsOutput().content(),
			postDetailsOutput.contentDetailsOutput().fromDate(),
			postDetailsOutput.contentDetailsOutput().toDate(),
			postDetailsOutput.contentDetailsOutput().rating(),
			postDetailsOutput.contentDetailsOutput().likeCount(),
			postDetailsOutput.contentDetailsOutput().bookmarkCount(),
			postDetailsOutput.contentDetailsOutput().isPublic()
		);

		MemberResponse memberResponse = new MemberResponse(
			postDetailsOutput.memberDetailsOutput().memberNo(),
			postDetailsOutput.memberDetailsOutput().nickname()
		);

		PostDetailsResponse postDetailsResponse = new PostDetailsResponse(
			postDetailsOutput.postId(),
			contentResponse,
			memberResponse
		);

		return postDetailsResponse;
	}
}

package com.inmybook.application.service;

import org.springframework.stereotype.Service;

import com.inmybook.application.port.in.ReadPostCommand;
import com.inmybook.application.port.in.ReadPostUseCase;
import com.inmybook.application.port.out.ReadPostPort;
import com.inmybook.domain.post.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadPostService implements ReadPostUseCase {
	private final ReadPostPort readPostPort;

	@Override
	public PostResponse findPostById(ReadPostCommand readPostCommand) {
		Post post = readPostPort.findPostById(readPostCommand.uuid());

		ContentResponse contentResponse = ContentResponse.builder()
			.title(post.getContent().getTitle())
			.content(post.getContent().getContent())
			.fromDate(post.getContent().getFromDate())
			.toDate(post.getContent().getToDate())
			.rating(post.getContent().getRating())
			.likeCount(post.getContent().getLikeCount())
			.bookmarkCount(post.getContent().getBookmarkCount())
			.isPublic(post.getContent().getIsPublic())
			.uuid(post.getContent().getUuid())
			.build();

		MemberResponse memberResponse = MemberResponse.builder()
			.memberNo(post.getMember().getMemberNo())
			.memberId(post.getMember().getMemberId())
			.nickname(post.getMember().getNickname())
			.build();

		PostResponse postResponse = PostResponse.builder()
			.contentResponse(contentResponse)
			.memberResponse(memberResponse)
			.build();

		return postResponse;
	}
}

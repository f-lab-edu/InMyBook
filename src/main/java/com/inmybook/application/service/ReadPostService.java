package com.inmybook.application.service;

import org.springframework.stereotype.Service;

import com.inmybook.application.port.in.ReadPostInput;
import com.inmybook.application.port.in.ReadPostUseCase;
import com.inmybook.application.port.out.ReadPostPort;
import com.inmybook.domain.post.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadPostService implements ReadPostUseCase {
	private final ReadPostPort readPostPort;

	@Override
	public PostDetailsOutput findPostById(ReadPostInput readPostInput) {
		Post post = readPostPort.findPostById(readPostInput.postId());

		ContentDetailsOutput contentDetailsOutput = ContentDetailsOutput.builder()
			.title(post.getContent().getTitle())
			.content(post.getContent().getContent())
			.fromDate(post.getContent().getFromDate())
			.toDate(post.getContent().getToDate())
			.rating(post.getContent().getRating())
			.likeCount(post.getContent().getLikeCount())
			.bookmarkCount(post.getContent().getBookmarkCount())
			.isPublic(post.getContent().getIsPublic())
			.build();

		MemberDetailsOutput memberDetailsOutput = MemberDetailsOutput.builder()
			.memberNo(post.getMember().getMemberNo())
			.memberId(post.getMember().getMemberId())
			.nickname(post.getMember().getNickname())
			.build();

		PostDetailsOutput postDetailsOutput = PostDetailsOutput.builder()
			.postId(post.getPostId())
			.contentDetailsOutput(contentDetailsOutput)
			.memberDetailsOutput(memberDetailsOutput)
			.build();

		return postDetailsOutput;
	}
}

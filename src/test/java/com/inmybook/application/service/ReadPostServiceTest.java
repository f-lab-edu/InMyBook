package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inmybook.adapter.out.InMemoryPostRepository;
import com.inmybook.application.port.in.ReadPostInput;
import com.inmybook.domain.member.Member;
import com.inmybook.domain.post.Content;
import com.inmybook.domain.post.Post;

@ExtendWith(MockitoExtension.class)
class ReadPostServiceTest {

	@InjectMocks
	ReadPostService readPostUseCase;

	@Mock
	InMemoryPostRepository readPostPort;

	@Test
	@DisplayName("사용자는 독서록 게시글을 조회할 수 있다.")
	void readPost() {
		String bookUuid = getUuid();

		Content content = Content.builder()
			.title("HTTP 완벽 가이드 독서록")
			.content("유익합니다.")
			.fromDate("2024-07-14")
			.toDate("2024-07-21")
			.rating(4.5)
			.likeCount(0)
			.bookmarkCount(0)
			.isPublic("Y")
			.build();

		Member member = Member.builder()
			.email("dani820@gmail.com")
			.nickname("dani")
			.build();

		Post post = Post.builder()
			.postId(bookUuid)
			.content(content)
			.member(member)
			.build();

		ReadPostInput mockReadPostInput = new ReadPostInput(bookUuid);

		when(readPostPort.findPostById(mockReadPostInput.uuid())).thenReturn(post);
		PostDetailsOutput postDetailsOutput = readPostUseCase.findPostById(mockReadPostInput);

		assertEquals("HTTP 완벽 가이드 독서록", postDetailsOutput.contentDetailsOutput().title());
		assertEquals("dani", postDetailsOutput.memberDetailsOutput().nickname());
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}
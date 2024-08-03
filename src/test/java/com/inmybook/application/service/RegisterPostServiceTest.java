package com.inmybook.application.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inmybook.adapter.in.web.dto.RegisterPostInputDto;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

@ExtendWith(MockitoExtension.class)
class RegisterPostServiceTest {

	@InjectMocks
	RegisterPostService registerPostUseCase;

	@Mock
	RegisterPostPort registerPostPort;

	@Mock
	PostFactory mockPostFactory;

	@Test
	@DisplayName("사용자는 독서록 게시글을 등록할 수 있다.")
	void registerPostTest() {
		// input : 책 정보, 유저 정보, 게시글 정보
		// output : 상세 조회 url
		
		PostFactory postFactory = new PostFactory();

		byte[] thumbnailData = new byte[0];
		RegisterPostInputDto registerPostInputDto = new RegisterPostInputDto(
			"9788966261208",
			"HTTP 완벽 가이드",
			"데이빗 골리 와 브라이언 토티",
			"인사이트",
			"HTTP 완벽 가이드 독서록",
			"유익합니다.",
			"2024-07-14",
			"2024-07-21",
			4.5,
			0,
			0,
			"Y",
			"dani820",
			"원본파일명",
			69835L,
			"png",
			thumbnailData
		);

		RegisterPostCommand registerPostCommand = RegisterPostCommand.builder()
			.isbnNo(registerPostInputDto.isbnNo())
			.bookName(registerPostInputDto.bookName())
			.author(registerPostInputDto.author())
			.publisher(registerPostInputDto.publisher())
			.title(registerPostInputDto.title())
			.content(registerPostInputDto.content())
			.fromDate(registerPostInputDto.fromDate())
			.toDate(registerPostInputDto.toDate())
			.rating(registerPostInputDto.rating())
			.likeCount(registerPostInputDto.likeCount())
			.bookmarkCount(registerPostInputDto.bookmarkCount())
			.isPublic(registerPostInputDto.isPublic())
			.memberId(registerPostInputDto.memberId())
			.thumbnailName(registerPostInputDto.thumbnailName())
			.thumbnailSize(registerPostInputDto.thumbnailSize())
			.thumbnailExt(registerPostInputDto.thumbnailExt())
			.thumbnailData(registerPostInputDto.thumbnailData())
			.build();

		Post post = postFactory.createPost(registerPostCommand);
		String path = post.createPostPath(1);
		when(mockPostFactory.createPost(registerPostCommand)).thenReturn(post);
		when(registerPostPort.registerPost(post)).thenReturn(path);

		assertThat(registerPostUseCase.registerPost(registerPostCommand)).isEqualTo(path);
	}

}
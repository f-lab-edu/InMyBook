package com.inmybook.application.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inmybook.adapter.in.web.dto.RegistPostInputDto;
import com.inmybook.application.port.in.RegistPostCommand;
import com.inmybook.application.port.out.RegistPostPort;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

@ExtendWith(MockitoExtension.class)
class RegistPostServiceTest {

	@InjectMocks
	RegistPostService registPostUsecase;

	@Mock
	RegistPostPort registPostPort;

	@Mock
	PostFactory postFactory;

	@Test
	@DisplayName("사용자는 독서록 게시글을 등록할 수 있다.")
	void registPostTest() {
		// input : 책 정보, 유저 정보, 게시글 정보
		// output : 상세 조회 url

		byte[] thumbnailData = new byte[0];
		RegistPostInputDto registPostInputDto = new RegistPostInputDto(
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

		RegistPostCommand registPostCommand = RegistPostCommand.builder()
			.isbnNo(registPostInputDto.isbnNo())
			.bookName(registPostInputDto.bookName())
			.author(registPostInputDto.author())
			.publisher(registPostInputDto.publisher())
			.title(registPostInputDto.title())
			.content(registPostInputDto.content())
			.fromDate(registPostInputDto.fromDate())
			.toDate(registPostInputDto.toDate())
			.rating(registPostInputDto.rating())
			.likeCount(registPostInputDto.likeCount())
			.bookmarkCount(registPostInputDto.bookmarkCount())
			.isPublic(registPostInputDto.isPublic())
			.memberId(registPostInputDto.memberId())
			.thumbnailName(registPostInputDto.thumbnailName())
			.thumbnailSize(registPostInputDto.thumbnailSize())
			.thumbnailExt(registPostInputDto.thumbnailExt())
			.thumbnailData(registPostInputDto.thumbnailData())
			.build();

		Post post = postFactory.createPost(registPostCommand);
		when(registPostPort.registPost(post)).thenReturn(1);

		String path = "/post/1";
		assertThat(registPostUsecase.registPost(registPostCommand)).isEqualTo(path);
	}

}
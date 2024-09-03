package com.inmybook.application.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import com.inmybook.adapter.out.InMemoryPostRepository;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

@ExtendWith(MockitoExtension.class)
class RegisterPostServiceTest {

	@InjectMocks
	RegisterPostService registerPostUseCase;

	@Mock
	InMemoryPostRepository registerPostPort;

	@Mock
	PostFactory mockPostFactory;

	@Test
	@DisplayName("사용자는 독서록 게시글을 등록할 수 있다.(썸네일 존재하는 경우)")
	void registerPostWithUploadImgTest() {
		// input : 책 정보, 유저 정보, 게시글 정보
		// output : 상세 조회 url

		PostFactory postFactory = new PostFactory();

		MultipartFile multipartFile = mock(MultipartFile.class);
		RegisterPostCommand registerPostCommand = RegisterPostCommand.builder()
			.isbnNo("9788966261208")
			.bookName("HTTP 완벽 가이드")
			.author("데이빗 골리 와 브라이언 토티")
			.publisher("인사이트")
			.title("HTTP 완벽 가이드 독서록")
			.content("유익합니다.")
			.fromDate("2024-07-14")
			.toDate("2024-07-21")
			.rating(4.5)
			.isPublic("Y")
			.memberId("dani820")
			.thumbnailImg(multipartFile)
			.build();

		Post post = postFactory.createPost(registerPostCommand);
		when(mockPostFactory.createPost(registerPostCommand)).thenReturn(post);
		when(registerPostPort.save(post)).thenReturn(post.getPostId());
		String path = post.createPostPath(post.getPostId());

		assertThat(registerPostUseCase.registerPost(registerPostCommand)).isEqualTo(path);
	}

	@Test
	@DisplayName("사용자는 독서록 게시글을 등록할 수 있다.(썸네일 존재하지 않는 경우)")
	void registerPostWithoutUploadImgTest() {
		// input : 책 정보, 유저 정보, 게시글 정보
		// output : 상세 조회 url

		PostFactory postFactory = new PostFactory();

		MultipartFile multipartFile = null;
		RegisterPostCommand registerPostCommand = RegisterPostCommand.builder()
			.isbnNo("9788966261208")
			.bookName("HTTP 완벽 가이드")
			.author("데이빗 골리 와 브라이언 토티")
			.publisher("인사이트")
			.title("HTTP 완벽 가이드 독서록")
			.content("유익합니다.")
			.fromDate("2024-07-14")
			.toDate("2024-07-21")
			.rating(4.5)
			.isPublic("Y")
			.memberId("dani820")
			.thumbnailImg(multipartFile)
			.build();

		Post post = postFactory.createPost(registerPostCommand);
		when(mockPostFactory.createPost(registerPostCommand)).thenReturn(post);
		when(registerPostPort.save(post)).thenReturn(post.getPostId());
		String path = post.createPostPath(post.getPostId());

		assertThat(registerPostUseCase.registerPost(registerPostCommand)).isEqualTo(path);
	}

}
package com.inmybook.domain.post;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import com.inmybook.application.port.in.RegisterPostCommand;

@ExtendWith(MockitoExtension.class)
class PostFactoryTest {

	@Mock
	RegisterPostCommand registerPostCommand;

	@InjectMocks
	PostFactory postFactory;

	@Test
	@DisplayName("Post 객체 생성 시 이미지 데이터 취득 중 IOException 발생 시 RuntimeException 처리")
	void createPostThrowRuntimeException() throws IOException {
		MultipartFile mockMultipartFile = mock(MultipartFile.class);

		when(mockMultipartFile.getBytes()).thenThrow(new IOException());
		when(registerPostCommand.thumbnailImg()).thenReturn(mockMultipartFile);

		assertThatThrownBy(() -> postFactory.createPost(registerPostCommand))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("독서록 게시글을 등록할 수 없습니다.");

	}
}
package com.inmybook.adapter.in.web;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmybook.adapter.in.web.dto.PostMapper;
import com.inmybook.adapter.in.web.dto.response.PostDetailsResponse;
import com.inmybook.application.port.in.ReadPostInput;
import com.inmybook.application.port.in.ReadPostUseCase;
import com.inmybook.application.service.ContentDetailsOutput;
import com.inmybook.application.service.MemberDetailsOutput;
import com.inmybook.application.service.PostDetailsOutput;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

	@InjectMocks
	PostController postController;
	@Mock
	ReadPostUseCase readPostUseCase;
	@Mock
	PostMapper postMapper;

	private MockMvc mockMvc;
	private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
	}

	@Test
	@DisplayName("사용자는 독서록 게시글을 조회할 수 있다.")
	void readPost() throws Exception {
		PostDetailsOutput mockPostDetailsOutput = getPostDetailsOutput();
		PostDetailsResponse mockPostDetailsResponse = getPostDetailsResponse(mockPostDetailsOutput);
		String postId = mockPostDetailsOutput.postId();
		when(readPostUseCase.findPostById(new ReadPostInput(postId))).thenReturn(mockPostDetailsOutput);
		when(postMapper.createReadPostDetailsResponse(mockPostDetailsOutput)).thenReturn(mockPostDetailsResponse);

		ResultActions resultActions = mockMvc.perform(get("/posts/{postId}", postId)
			.contentType(MediaType.APPLICATION_JSON)
			.characterEncoding("utf-8")
			.content(postId)
		);

		MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

		PostDetailsResponse postDetailsResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(
			StandardCharsets.UTF_8), PostDetailsResponse.class);

		assertThat(postDetailsResponse.postId()).isEqualTo(postId);
		assertThat(postDetailsResponse.contentResponse().title()).isEqualTo("HTTP 완벽 가이드 독서록");
	}

	private PostDetailsResponse getPostDetailsResponse(PostDetailsOutput postDetailsOutput) {
		PostMapper postMapper = new PostMapper();
		return postMapper.createReadPostDetailsResponse(postDetailsOutput);
	}

	private PostDetailsOutput getPostDetailsOutput() {
		String postId = getUuid();

		ContentDetailsOutput contentDetailsOutput = new ContentDetailsOutput(
			"HTTP 완벽 가이드 독서록",
			"유익합니다.",
			"2024-07-14",
			"2024-07-21",
			4.5,
			0,
			0,
			"Y"
		);

		MemberDetailsOutput memberDetailsOutput = new MemberDetailsOutput(
			0L,
			"dani820",
			"dani820"
		);

		PostDetailsOutput postDetailsOutput = new PostDetailsOutput(
			postId,
			contentDetailsOutput,
			memberDetailsOutput
		);

		return postDetailsOutput;
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}

}
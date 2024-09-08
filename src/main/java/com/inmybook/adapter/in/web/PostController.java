package com.inmybook.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inmybook.adapter.in.web.dto.PostMapper;
import com.inmybook.adapter.in.web.dto.RegisterPostInput;
import com.inmybook.adapter.in.web.dto.response.PostDetailsResponse;
import com.inmybook.application.port.in.ReadPostInput;
import com.inmybook.application.port.in.ReadPostUseCase;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.port.in.RegisterPostUseCase;
import com.inmybook.application.service.PostDetailsOutput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post", description = "Post API")
@RestController
@RequiredArgsConstructor
public class PostController {

	private final RegisterPostUseCase registerPostUseCase;
	private final ReadPostUseCase readPostUseCase;
	private final PostMapper postMapper;

	@Operation(summary = "독서록 게시글 등록", description = "사용자는 독서록 게시글을 등록할 수 있다.")
	@ApiResponse(
		responseCode = "201", description = "독서록 게시글 등록 성공"
	)
	@PostMapping(value = "/posts", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> registerPost(@RequestPart RegisterPostInput registerPostInput,
		@RequestPart(value = "uploadImg", required = false) MultipartFile multipartFile) {

		RegisterPostCommand registerPostCommand = postMapper.createRegisterPostCommand(registerPostInput,
			multipartFile);
		String path = registerPostUseCase.registerPost(registerPostCommand);

		return new ResponseEntity<>(path, HttpStatus.CREATED);
	}

	@Operation(summary = "독서록 책 정보 조회", description = "사용자는 독서록 게시글을 조회할 수 있다.")
	@ApiResponse(
		responseCode = "200", description = "독서록 게시글 조회 성공"
	)
	@GetMapping(value = "/posts/{postId}")
	public ResponseEntity<PostDetailsResponse> getContent(@PathVariable String postId) {
		ReadPostInput readPostInput = new ReadPostInput(postId);
		PostDetailsOutput postDetailsOutput = readPostUseCase.findPostById(readPostInput);

		PostDetailsResponse postDetailsResponse = postMapper.createReadPostDetailsResponse(postDetailsOutput);

		return new ResponseEntity<>(postDetailsResponse, HttpStatus.OK);
	}
}

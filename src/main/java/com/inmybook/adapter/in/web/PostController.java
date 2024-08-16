package com.inmybook.adapter.in.web;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.inmybook.adapter.in.web.dto.PostMapper;
import com.inmybook.adapter.in.web.dto.RegisterPostInput;
import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.port.in.RegisterPostUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post", description = "Post API")
@RestController
@RequiredArgsConstructor
public class PostController {

	private final RegisterPostUseCase registerPostUseCase;
	private final PostMapper postMapper;

	@Operation(
		summary = "독서록 게시글 등록",
		description = "사용자는 독서록 게시글을 등록할 수 있다."
	)
	@ApiResponse(
		responseCode = "201",
		description = "독서록 게시글 등록 성공"
	)
	@PostMapping(value = "/posts", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> registerPost(@RequestPart RegisterPostInput registerPostInput,
		@RequestPart(value = "uploadImg", required = false) MultipartFile multipartFile) {

		RegisterPostCommand registerPostCommand = postMapper.createRegisterPostCommand(registerPostInput,
			multipartFile);
		String path = "";
		try {
			path = registerPostUseCase.registerPost(registerPostCommand);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "독서록 게시글을 등록할 수 없습니다.",
				new IOException());
		}

		return new ResponseEntity<>(path, HttpStatus.CREATED);
	}
}

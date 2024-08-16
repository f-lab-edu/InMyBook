package com.inmybook.application.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.port.in.RegisterPostUseCase;
import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterPostService implements RegisterPostUseCase {
	private final PostFactory postFactory;
	private final RegisterPostPort registerPostPort;

	@Override
	public String registerPost(RegisterPostCommand registerPostCommand) throws IOException {
		Post post = postFactory.createPost(registerPostCommand);
		Long postNo = registerPostPort.save(post);
		String path = post.createPostPath(postNo);

		return path;
	}
}

package com.inmybook.application.service;

import com.inmybook.application.port.in.RegisterPostCommand;
import com.inmybook.application.port.in.RegisterPostUseCase;
import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterPostService implements RegisterPostUseCase {
	private final PostFactory postFactory;
	private final RegisterPostPort registerPostPort;

	@Override
	public String registerPost(RegisterPostCommand registerPostCommand) {
		Post post = postFactory.createPost(registerPostCommand);
		int postNum = registerPostPort.registerPost(post);

		String path = "/post/" + postNum;
		return path;
	}
}

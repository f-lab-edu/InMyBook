package com.inmybook.application.service;

import com.inmybook.application.port.in.RegistPostCommand;
import com.inmybook.application.port.in.RegistPostUsecase;
import com.inmybook.application.port.out.RegistPostPort;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.PostFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistPostService implements RegistPostUsecase {
	private final PostFactory postFactory;
	private final RegistPostPort registPostPort;

	@Override
	public String registPost(RegistPostCommand registPostCommand) {
		Post post = postFactory.createPost(registPostCommand);
		int postNum = registPostPort.registPost(post);

		String path = "/post/" + postNum;
		return path;
	}
}

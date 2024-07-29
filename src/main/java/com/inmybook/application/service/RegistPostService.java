package com.inmybook.application.service;

import com.inmybook.adapter.in.web.dto.PostDto;
import com.inmybook.application.port.in.RegistPostUsecase;
import com.inmybook.domain.post.PostFactory;

public class RegistPostService implements RegistPostUsecase {
		private final PostFactory postFactory = new PostFactory();
		// private final PostRepository postRepository = new PostRepositoryImpl();

		@Override
		public void registPost(PostDto postDto) {
				// Post post = postFactory.createPost(postDto);
				// postRepository.registPost(post);
		}
}

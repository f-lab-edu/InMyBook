package com.inmybook.adapter.out;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;

@Repository
public class InMemoryPostRepository implements RegisterPostPort {
	private final HashMap<Long, Post> memory = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Long save(Post post) {
		post.setPostId(++sequence);
		memory.put(post.getPostId(), post);
		return post.getPostId();
	}
}

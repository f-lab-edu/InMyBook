package com.inmybook.adapter.out;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.inmybook.application.port.out.ReadPostPort;
import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;

@Repository
public class InMemoryPostRepository implements RegisterPostPort, ReadPostPort {
	private final HashMap<Long, Post> memory = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public String save(Post post) {
		long id = ++sequence;
		memory.put(id, post);
		return post.getPostId();
	}

	@Override
	public Post findPostById(String id) {
		for (Post post : memory.values()) {
			if (post.getPostId().equals(id)) {
				return post;
			}
		}
		throw new RuntimeException("독서록 정보를 찾을 수 없습니다.");
	}
}

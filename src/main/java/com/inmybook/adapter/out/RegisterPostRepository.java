package com.inmybook.adapter.out;

import org.springframework.stereotype.Repository;

import com.inmybook.application.port.out.RegisterPostPort;
import com.inmybook.domain.post.Post;

@Repository
public class RegisterPostRepository implements RegisterPostPort {
	@Override
	public String registerPost(Post post) {
		return "1";
	}
}

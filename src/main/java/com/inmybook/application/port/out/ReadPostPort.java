package com.inmybook.application.port.out;

import com.inmybook.domain.post.Post;

public interface ReadPostPort {
	/**
	 * @NOTE 독서록 게시글 정보를 조회한다.
	 *
	 * @param id
	 * @return
	 */
	Post findPostById(String id);
}

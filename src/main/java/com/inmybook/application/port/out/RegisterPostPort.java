package com.inmybook.application.port.out;

import com.inmybook.domain.post.Post;

public interface RegisterPostPort {
	/**
	 * @NOTE 사용자가 작성한 독서록 게시글 정보를 등록한다.
	 *
	 * @param post
	 * @return 독서록 상세 조회 API Path
	 */
	public String save(Post post);
}

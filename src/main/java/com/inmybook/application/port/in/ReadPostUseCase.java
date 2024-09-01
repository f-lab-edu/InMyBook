package com.inmybook.application.port.in;

import com.inmybook.application.service.PostDetailsOutput;

public interface ReadPostUseCase {
	/**
	 * @NOTE 독서록 게시글 정보를 조회한다.
	 *
	 * @param readPostInput
	 * @return
	 */
	public PostDetailsOutput findPostById(ReadPostInput readPostInput);
}

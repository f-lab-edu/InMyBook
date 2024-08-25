package com.inmybook.application.port.in;

import com.inmybook.application.service.PostResponse;

public interface ReadPostUseCase {
	/**
	 * @NOTE 독서록 게시글 정보를 조회한다.
	 *
	 * @param readPostCommand
	 * @return
	 */
	public PostResponse findPostById(ReadPostCommand readPostCommand);
}

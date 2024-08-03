package com.inmybook.application.port.in;

public interface RegisterPostUseCase {
	/**
	 * @NOTE 사용자가 작성한 독서록 게시글 정보를 등록한다.
	 *
	 * @param registerPostCommand
	 * @return 독서록 상세 조회 API Path
	 */
	public String registerPost(RegisterPostCommand registerPostCommand);
}

package com.inmybook.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
	private String memberId;
	private String nickname;
	private String email;
	private String password;
}

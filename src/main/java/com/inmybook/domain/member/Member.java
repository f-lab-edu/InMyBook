package com.inmybook.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	private String memberId;
	private String nickname;
	private String email;
	private String password;
}

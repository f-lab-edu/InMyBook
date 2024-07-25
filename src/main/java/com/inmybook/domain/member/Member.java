package com.inmybook.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Member {
	String memberId;
	String nickname;
	String email;
	String password;
}

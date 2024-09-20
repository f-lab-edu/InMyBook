package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberDetailsOutputTest {

	String memberId;

	@BeforeEach
	void setUp() throws Exception {
		memberId = getUuid();
	}

	@Test
	@DisplayName("Service Layer 사용자 정보 응답 DTO Constructor 검증")
	void testConstructor() {
		MemberDetailsOutput memberDetails = MemberDetailsOutput.builder()
			.memberId(memberId)
			.nickname("JohnDoe")
			.build();

		assertNotNull(memberDetails);
		assertEquals(memberId, memberDetails.memberId());
		assertEquals("JohnDoe", memberDetails.nickname());
	}

	@Test
	@DisplayName("Service Layer 사용자 정보 응답 DTO Getter 검증")
	void testGetter() {
		MemberDetailsOutput memberDetails = MemberDetailsOutput.builder()
			.memberId(memberId)
			.nickname("JaneDoe")
			.build();

		assertEquals(memberId, memberDetails.memberId());
		assertEquals("JaneDoe", memberDetails.nickname());
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}
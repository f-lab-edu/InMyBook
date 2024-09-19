package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostDetailsOutputTest {

	String memberId;
	String postId;

	@BeforeEach
	void setUp() throws Exception {
		memberId = getUuid();
		postId = getUuid();
	}

	@Test
	@DisplayName("Service Layer 사용자 정보를 포함한 독서록 정보(책 정보 제외) 응답 DTO Constructor 검증")
	void testConstructor() {
		ContentDetailsOutput contentDetails = ContentDetailsOutput.builder()
			.title("그럼에도 계속 살아간다.")
			.content("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.")
			.readingStartDate("2024-09-01")
			.readingEndDate("2024-09-15")
			.rating(4.5)
			.likeCount(120)
			.bookmarkCount(50)
			.isPublic("true")
			.build();

		MemberDetailsOutput memberDetails = MemberDetailsOutput.builder()
			.memberId(memberId)
			.nickname("JohnDoe")
			.build();

		PostDetailsOutput postDetails = PostDetailsOutput.builder()
			.postId(postId)
			.contentDetailsOutput(contentDetails)
			.memberDetailsOutput(memberDetails)
			.build();

		assertNotNull(postDetails);
		assertEquals(postId, postDetails.postId());
		assertEquals(contentDetails, postDetails.contentDetailsOutput());
		assertEquals(memberDetails, postDetails.memberDetailsOutput());
	}

	@Test
	@DisplayName("Service Layer 사용자 정보를 포함한 독서록 정보(책 정보 제외) 응답 DTO Getter 검증")
	void testGetter() {
		ContentDetailsOutput contentDetails = ContentDetailsOutput.builder()
			.title("그럼에도 계속 살아간다.")
			.content("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.")
			.readingStartDate("2024-09-01")
			.readingEndDate("2024-09-15")
			.rating(4.8)
			.likeCount(200)
			.bookmarkCount(75)
			.isPublic("false")
			.build();

		MemberDetailsOutput memberDetails = MemberDetailsOutput.builder()
			.memberId(memberId)
			.nickname("JaneDoe")
			.build();

		PostDetailsOutput postDetails = PostDetailsOutput.builder()
			.postId(postId)
			.contentDetailsOutput(contentDetails)
			.memberDetailsOutput(memberDetails)
			.build();

		assertEquals(postId, postDetails.postId());
		assertEquals(contentDetails, postDetails.contentDetailsOutput());
		assertEquals(memberDetails, postDetails.memberDetailsOutput());
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}
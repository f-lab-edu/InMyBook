package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContentDetailsOutputTest {
	@Test
	@DisplayName("Service Layer 독서록 정보 응답 DTO Constructor 검증")
	void testConstructor() {
		ContentDetailsOutput contentDetails = ContentDetailsOutput.builder()
			.title("그럼에도 계속 살아간다.")
			.content("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.")
			.readingStartDate("2024-09-01")
			.readingEndDate("2024-09-15")
			.rating(5.0)
			.likeCount(0)
			.bookmarkCount(0)
			.isPublic("true")
			.build();

		assertNotNull(contentDetails);
		assertEquals("그럼에도 계속 살아간다.", contentDetails.title());
		assertEquals("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.", contentDetails.content());
		assertEquals("2024-09-01", contentDetails.readingStartDate());
		assertEquals("2024-09-15", contentDetails.readingEndDate());
		assertEquals(5.0, contentDetails.rating());
		assertEquals(0, contentDetails.likeCount());
		assertEquals(0, contentDetails.bookmarkCount());
		assertEquals("true", contentDetails.isPublic());
	}

	@Test
	@DisplayName("Service Layer 독서록 정보 응답 DTO Getter 검증")
	void testGetter() {
		ContentDetailsOutput contentDetails = ContentDetailsOutput.builder()
			.title("그럼에도 계속 살아간다.")
			.content("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.")
			.readingStartDate("2024-09-01")
			.readingEndDate("2024-09-15")
			.rating(5.0)
			.likeCount(200)
			.bookmarkCount(75)
			.isPublic("false")
			.build();

		assertEquals("그럼에도 계속 살아간다.", contentDetails.title());
		assertEquals("더스트로 뿌옇게 뒤덮인 미래가 계속 될지라도 희망은 계속된다.", contentDetails.content());
		assertEquals("2024-09-01", contentDetails.readingStartDate());
		assertEquals("2024-09-15", contentDetails.readingEndDate());
		assertEquals(5.0, contentDetails.rating());
		assertEquals(200, contentDetails.likeCount());
		assertEquals(75, contentDetails.bookmarkCount());
		assertEquals("false", contentDetails.isPublic());
	}
}
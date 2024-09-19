package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookDetailsOutputTest {
	@Test
	@DisplayName("Service Layer 책 정보 응답 DTO Constructor 검증")
	void testConstructor() {
		BookDetailsOutput bookDetails = BookDetailsOutput.builder()
			.isbnNo("9791191824001")
			.bookName("지구 끝의 온실")
			.author("김초엽")
			.publisher("자이언트북스")
			.build();

		assertNotNull(bookDetails);
		assertEquals("9791191824001", bookDetails.isbnNo());
		assertEquals("지구 끝의 온실", bookDetails.bookName());
		assertEquals("김초엽", bookDetails.author());
		assertEquals("자이언트북스", bookDetails.publisher());
	}

	@Test
	@DisplayName("Service Layer 책 정보 응답 DTO Getter 검증")
	void testGetter() {
		BookDetailsOutput bookDetails = BookDetailsOutput.builder()
			.isbnNo("9791191824001")
			.bookName("지구 끝의 온실")
			.author("김초엽")
			.publisher("자이언트북스")
			.build();

		assertEquals("9791191824001", bookDetails.isbnNo());
		assertEquals("지구 끝의 온실", bookDetails.bookName());
		assertEquals("김초엽", bookDetails.author());
		assertEquals("자이언트북스", bookDetails.publisher());
	}

}
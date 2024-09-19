package com.inmybook.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThumbnailDetailsOutputTest {
	@Test
	@DisplayName("Service Layer 사용자가 직접 등록한 썸네일 정보 응답 DTO Constructor 검증")
	void testConstructor() {
		byte[] thumbnailData = new byte[] {1, 2, 3, 4, 5};

		ThumbnailDetailsOutput thumbnailDetails = ThumbnailDetailsOutput.builder()
			.thumbnailData(thumbnailData)
			.build();

		assertNotNull(thumbnailDetails);
		assertArrayEquals(thumbnailData, thumbnailDetails.thumbnailData());
	}

	@Test
	@DisplayName("Service Layer 사용자가 직접 등록한 썸네일 정보 응답 DTO Constructor 검증")
	void testGetter() {
		byte[] thumbnailData = new byte[] {10, 20, 30, 40, 50};

		ThumbnailDetailsOutput thumbnailDetails = ThumbnailDetailsOutput.builder()
			.thumbnailData(thumbnailData)
			.build();

		assertArrayEquals(thumbnailData, thumbnailDetails.thumbnailData());
	}

}
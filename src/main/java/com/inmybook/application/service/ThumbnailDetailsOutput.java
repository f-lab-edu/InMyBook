package com.inmybook.application.service;

import lombok.Builder;

@Builder
public record ThumbnailDetailsOutput(
	byte[] thumbnailData
) {
}

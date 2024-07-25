package com.inmybook.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record ThumbnailDto (
	String thumbnailName,
	Long thumbnailSize,
	String thumbnailExt,
	byte[] thumbnailData
) {
}

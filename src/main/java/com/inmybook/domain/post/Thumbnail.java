package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Thumbnail {
	private String thumbnailName;
	private String thumbnailType;
	private Long thumbnailSize;
	private byte[] thumbnailData;
}

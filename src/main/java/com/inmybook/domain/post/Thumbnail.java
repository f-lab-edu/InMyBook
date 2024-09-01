package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Thumbnail {
	private String thumbnailName;
	private String thumbnailType;
	private Long thumbnailSize;
	private byte[] thumbnailData;
}

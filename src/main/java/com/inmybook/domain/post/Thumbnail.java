package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Thumbnail {
	String thumbnailName;
	Long thumbnailSize;
	String thumbnailExt;
	byte[] thumbnailData;
}

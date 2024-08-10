package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Thumbnail {
	private int thumbnailId;
	private String thumbnailName;
	private String thumbnailType;
	private Long thumbnailSize;
	private byte[] thumbnailData;

	public Thumbnail(String thumbnailName, String thumbnailType, Long thumbnailSize, byte[] thumbnailData) {
		this.thumbnailName = thumbnailName;
		this.thumbnailType = thumbnailType;
		this.thumbnailSize = thumbnailSize;
		this.thumbnailData = thumbnailData;
	}
}

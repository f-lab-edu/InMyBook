package com.inmybook.domain.post;

import lombok.Builder;

@Builder
public class Content {
	private int contentId;
	private String title;
	private String content;
	private String fromDate;
	private String toDate;
	@Builder.Default
	private double rating = 0;
	@Builder.Default
	private int likeCount = 0;
	@Builder.Default
	private int bookmarkCount = 0;
	private String isPublic;
}

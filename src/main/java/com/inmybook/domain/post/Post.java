package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	private String isbnNo;
	private String bookName;
	private String author;
	private String publisher;
	private String title;
	private String content;
	private String fromDate;
	private String toDate;
	private double rating;
	private int likeCount;
	private int bookmarkCount;
	private String isPublic;
	private String memberId;
	private String thumbnailName;
	private Long thumbnailSize;
	private String thumbnailExt;
	@Builder.Default
	private byte[] thumbnailData = new byte[0];

	public String createPostPath(int id) {
		String path = "/post/" + id;
		return path;
	}
}

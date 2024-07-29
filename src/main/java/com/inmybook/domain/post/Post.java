package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	String isbnNo;
	String bookName;
	String author;
	String publisher;
	String title;
	String content;
	String fromDate;
	String toDate;
	double rating;
	int likeCount;
	int bookmarkCount;
	String isPublic;
	String memberId;
	String thumbnailName;
	Long thumbnailSize;
	String thumbnailExt;
	@Builder.Default
	byte[] thumbnailData = new byte[0];
}

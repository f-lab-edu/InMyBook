package com.inmybook.domain.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Post {
	String isbnNo;
	String bookName;
	String author;
	String publisher;
	Thumbnail thumbnail;
	String title;
	String content;
	double rating;
	int likeCount;
	int bookmarkCount;
	String isPublic;
	String memberId;
}

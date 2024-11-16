package com.inmybook.adapter.out.dto;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Attach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attach_id")
	private Long id;
	private String fileName;
	private String orgFileName;
	private String fileExt;
	private byte[] fileData;
	private int fileSize;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "book_id")
	private Book book;

	@Builder
	public Attach(String fileName, String orgFileName, String fileExt, byte[] fileData, int fileSize,
		Book book) {
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.fileExt = fileExt;
		this.fileData = fileData;
		this.fileSize = fileSize;
		this.book = book;
	}
}

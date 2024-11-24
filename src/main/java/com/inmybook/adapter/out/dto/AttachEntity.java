package com.inmybook.adapter.out.dto;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "ATTACH")
@Entity
public class AttachEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTACH_ID")
	private Long id;
	private String fileName;
	private String orgFileName;
	private String fileExt;

	@Lob
	@Column(name = "FILE_DATA", nullable = false, columnDefinition = "blob")
	private byte[] fileData;
	private int fileSize;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "BOOK_ID")
	private BookEntity book;

	@Builder
	public AttachEntity(String fileName, String orgFileName, String fileExt, byte[] fileData, int fileSize,
		BookEntity book) {
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.fileExt = fileExt;
		this.fileData = fileData;
		this.fileSize = fileSize;
		this.book = book;
	}
}

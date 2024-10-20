package com.inmybook.adapter.out.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
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
	private Long fileSize;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;

	@Builder
	public Attach(String fileName, String orgFileName, String fileExt, byte[] fileData, Long fileSize,
		Book book) {
		Attach attach = new Attach();
		attach.setFileName(fileName);
		attach.setOrgFileName(orgFileName);
		attach.setFileExt(fileExt);
		attach.setFileData(fileData);
		attach.setFileSize(fileSize);
		attach.setBook(book);
	}
}

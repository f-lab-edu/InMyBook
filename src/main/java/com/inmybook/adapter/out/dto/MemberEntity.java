package com.inmybook.adapter.out.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "MEMBER")
@Entity
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;
	private String email;
	private String password;
	private String nickname;
	private String useYn;
	private String memberUuid;

	@OneToMany(mappedBy = "member")
	private List<PostEntity> posts = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<CommentEntity> comments = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<BookmarkEntity> bookmarks = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<LikeEntity> likes = new ArrayList<>();

	@Builder
	public MemberEntity(String email, String password, String nickname, String useYn, String memberUuid) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.useYn = useYn;
		this.memberUuid = memberUuid;
	}
}

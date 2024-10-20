package com.inmybook.adapter.out.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	private String email;
	private String password;
	private String nickname;
	private String useYn;
	private String memberUuid;

	@OneToMany(mappedBy = "member")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "member")
	private List<Bookmark> bookmarks = new ArrayList<>();

	@Builder
	public Member(String email, String password, String nickname, String useYn, String memberUuid) {
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
		this.setUseYn(useYn);
		this.setMemberUuid(memberUuid);
	}
}

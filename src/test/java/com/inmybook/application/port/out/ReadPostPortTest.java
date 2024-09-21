package com.inmybook.application.port.out;

import static org.assertj.core.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inmybook.adapter.out.InMemoryPostRepository;
import com.inmybook.domain.member.Member;
import com.inmybook.domain.post.Book;
import com.inmybook.domain.post.Content;
import com.inmybook.domain.post.Post;
import com.inmybook.domain.post.Thumbnail;

@ExtendWith(MockitoExtension.class)
class ReadPostPortTest {

	@InjectMocks
	InMemoryPostRepository readPostPort;

	private Post post;
	private String bookUuid = "";

	@BeforeEach
	void init() {
		bookUuid = getUuid();

		Thumbnail thumbnail = null;
		Book book = Book.builder()
			.isbnNo("9788966261208")
			.bookName("HTTP 완벽 가이드")
			.author("데이빗 골리 와 브라이언 토티")
			.publisher("인사이트")
			.thumbnail(thumbnail)
			.build();

		Content content = Content.builder()
			.title("HTTP 완벽 가이드 독서록")
			.content("유익합니다.")
			.readingStartDate("2024-07-14")
			.readingEndDate("2024-07-21")
			.rating(4.5)
			.likeCount(0)
			.bookmarkCount(0)
			.isPublic("Y")
			.build();

		String memberId = getUuid();
		Member member = Member.builder()
			.memberId(memberId)
			.nickname("dani")
			.build();

		post = Post.builder()
			.postId(bookUuid)
			.book(book)
			.content(content)
			.member(member)
			.build();
	}

	@Test
	@DisplayName("독서록 게시글 조회 성공")
	void findPostById() {
		readPostPort.save(post);

		Post post = readPostPort.findPostById(bookUuid);

		assertThat(post).isNotNull();
		assertThat(post.getContent().getTitle()).isEqualTo("HTTP 완벽 가이드 독서록");
		assertThat(post.getMember().getNickname()).isEqualTo("dani");
	}

	@Test
	@DisplayName("독서록 게시글 조회 실패")
	void findPostByIdThrowRuntimeException() {
		assertThatThrownBy(() -> readPostPort.findPostById(bookUuid))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("독서록 정보를 찾을 수 없습니다.");
	}

	private String getUuid() {
		return UUID.randomUUID().toString();
	}
}
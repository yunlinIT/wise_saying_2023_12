package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository { // 레포지토리 클래스

	private int lastWiseSayingId;  // 변수
	private List<WiseSaying> wiseSayings; // 어래이리스트타입의 변수

<<<<<<< HEAD
	public WiseSayingRepository() {
		lastWiseSayingId = 0;
		wiseSayings = new ArrayList<>();
=======
	public WiseSayingRepository() { // 생성자. wiseSayingRepository 객체 생성과 동시에
		lastWiseSayingId = 0;  // 변수 세팅하고 0으로 초기화
		wiseSayings = new ArrayList<>(); // 어래이리스트 만듬
>>>>>>> 73c3a69c5417c8991266fe515dd8840da429c183
	}

	public void remove(WiseSaying wiseSaying) { // 서비스한테 넘겨받은 wiseSaying 명언객체를
		wiseSayings.remove(wiseSaying); // 어래이리스트를호출하여 삭제함
	}

	public WiseSaying findById(int id) { // 서비스에서 넘겨받은 정수형 인자를 받아서 아래 for-each문을실행할거야
		for (WiseSaying wiseSaying : wiseSayings) { // 어래이리스트에 들어있는 리스트들 다 순환해서
			if (wiseSaying.getId() == id) { // 넘겨받은 정수(id)랑 실제로 객체에 조립되어있던 게터로 불러와서 비교해서 일치하면 
				return wiseSaying; // 일치하던 그 객체를 서비스한테 리턴함
			}
		}

		return null; // 일치하는 것이 없으면 널 값을 리턴 함
	}

	public void modify(WiseSaying wiseSaying, String content, String author) { // 서비스에서 인자 받아서
		wiseSaying.setContent(content); // WiseSaying클래스에 세터 사용해서 private content에 새로운 명언 덮어쓰기
		wiseSaying.setAuthor(author); // WiseSaying클래스에 세터 사용해서 =private author에 새로운 작가 덮어쓰기
	}

	public int write(String content, String author) { // int형 타입을 리턴할 메서드, 컨트롤러에서 입력받아 서비스로부터 넘겨받은 content와 author 인자를 매개변수에 담음
		int id = lastWiseSayingId + 1; // content와 author과 함께 조립될 lastWiseSayingId라는 1씩 증가되는 정수를 id라는 변수에 담음 (명언,작가 넘어올때마다 부여해주는 번호표같은 느낌)

		WiseSaying wiseSaying = new WiseSaying(id, content, author); // 넘겨받은 content(명언), author(작가), id(번호)를 wiseSaying객체에 조립해서 담음
		wiseSayings.add(wiseSaying); // 번호,명언,작가가 그룹화 된 객체를 wiseSayings 어레이리스트에 저장

		lastWiseSayingId = id; // 방금 전에 새 명언과 함께 번호가 생겼으니, lastWiseSayingId의 값을 갱신(추후에 새로운 명언/작가한테 부여해줄 번호를 위해 준비하는 과정)

		return id; // 어래이리스트에 담길때 조립 된 id를 서비스한테 리턴. (서비스는 그걸 컨트롤러한테 리턴)
	}

	public List<WiseSaying> findAll() { // 어레이리슽 타입을 리턴 할 메서드
		return wiseSayings; // 어레이리스트의 데이터들을 서비스클래스한테 리턴할거야
	}

}
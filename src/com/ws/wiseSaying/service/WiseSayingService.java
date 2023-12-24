package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService { // 서비스 클래스

	private WiseSayingRepository wiseSayingRepository; // WiseSayingRepository 변수

	public WiseSayingService() { // 생성자. wiseSayingService 객체 생성과 동시에 

		wiseSayingRepository = new WiseSayingRepository(); // WiseSayingRepository 객체 만듬
	}

	public List<WiseSaying> findAll() { // 어레이리스트타입을 리턴 할 findAll이라는 메서드
		return wiseSayingRepository.findAll(); // 레포지토리에서 리턴받은 어레이리스트 데이터들을 컨트롤러한테 리턴함
	}

	public int write(String content, String author) { // 컨트롤러에서입력받은 content와 author 인자를 매개변수로 받아서,

		return wiseSayingRepository.write(content, author); // 레포지토리에 넘겨주고 되돌려받아낸 정수타입의 리턴값(id)을 컨트롤러한테 리턴할거야.
	
	}

	public WiseSaying findById(int id) { // WiseSaying객체 타입으로 리턴 할 findById라는 메서드인데, int형 인자를 id매개변수(파라미터)로 받아서
		return wiseSayingRepository.findById(id); // 레포지토리한테 넘겨주고 리턴받은 객체를 컨트롤러한테 리턴함
	}

	public void remove(WiseSaying wiseSaying) { // 컨트롤러한테 삭제요청받은 wiseSaying 명언 객체를 매개변수로 받은 메서드
		wiseSayingRepository.remove(wiseSaying); // 받은 매개변수를 다시 인자로 레포지토리한테 넘겨줌
	}

	public void modify(WiseSaying wiseSaying, String content, String author) { // 컨트롤러한테 입력받은 객체와 명언 작가 인자를 담아서
		wiseSayingRepository.modify(wiseSaying, content, author); // 레포지토리 함수 호출하면서 인자 넘겨주기

	}

}
package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService; // WiseSayingService 클라스로 만든 wiseSayingService 변수(리모콘)

	public WiseSayingController() { // WiseSayingController 생성자(클래스이름이랑 똑같으니까) 메서드를 실행함과 동시에 
		wiseSayingService = new WiseSayingService(); //  WiseSayingService클래스로 WiseSayingService객체 하나 만들어서 wiseSayingService 변수리모콘에 저장
	}

	public void write() {
		System.out.print("명언 : "); //명언 입력받을거야
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : "); // 작가 입력받을거야
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author); // 이해안됌 ㅠㅜㅜ 서비스랑 컨트롤러중에 누가 먼저 입력받는건지 모르겠음
		
		// 입력받은걸 서비스에서 뭔가를 해서 다시 컨트롤러한테 돌려주고 ID에 넣는다는건가ㅣ???
				// 그럼 서비스에서 뭘 했는데? 객체만듬. 명언 작가 번호를 조립하기 위한 객체인듯
				// 객체에서 조립된 명언과 작가를 id라는 변수에 넣을 거. id는 입력당시 생성된 명언과 작가와 짝꿍 될 번호인듯.
				// 어떻게? WiseSayingService 클래스에 있는 wiseSayingService라는 리모콘으로 연결해서 WiseSayingService클래스 안에 있는 write(String content, String author) 메서드를 실행하면서 content와 author인자에 저장해서 .
				// 컨트롤러랑 서비스랑 서로 어떤 관계인진 알겠는데, 서로 어떻게 데이터를 주고받으면서 상호작용이 이루어지는지 명확하게 눈으로 쫒아가지지가 않음 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
				// 컨트롤러랑 서비스랑 업무를 분담하니까 헷갈림. 그들의 각각 개인의 업무들을 퍼즐/톱니바퀴처럼 끼워맞춰지는게 눈으로 그려지지가 않음 
				// 흑흑흐그흑흐긓긓그흑흐긓그흑흑흑흑흑흐ㅜㅜㅜㅜㅠ

				//   ArrayList 안에 content랑 author의 값을 넣어서 id라는 변수에 넣고 번호를 부여해준다?

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll(); // 여긴 왜 리스트가있지? 서비스 안에도 리스트있던데, 여기서도 누가 먼저임? 
		// 목록을 ArrayList

		System.out.println("번호  /  작가  /  명언  "); //
		System.out.println("=".repeat(30));

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {
			WiseSaying ws = wiseSayings.get(i);

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}
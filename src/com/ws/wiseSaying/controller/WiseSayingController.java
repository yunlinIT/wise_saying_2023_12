package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

<<<<<<< HEAD
public class WiseSayingController { // 컨트롤러 클래스

	private WiseSayingService wiseSayingService; // WiseSayingService 클라스로 만든 wiseSayingService 변수(리모콘)

	public WiseSayingController() { // 생성자. wiseSayingController 객체 생성과 동시에 
		wiseSayingService = new WiseSayingService(); //  WiseSayingService객체 하나 만듬
	}

	public void write() { // write 메서드를 실행, 받아적는 역할
		System.out.print("명언 : "); //명언 입력받음
		String content = Container.getScanner().nextLine().trim(); // 입력받은거 content라는 공간에 String타입으로 넣음
		System.out.print("작가 : "); // 작가 입력받음
		String author = Container.getScanner().nextLine().trim(); // 입력받은거 author이라는 공간에 String타입으로 넣음
 
		int id = wiseSayingService.write(content, author); // 입력받은 content와 author을 서비스클래스에 있는 메서드한테 인자로 던져주고,서비스한테 되돌려받은 정수형 리턴값을 id라는 공간에 담음

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // id라는 공간에 저장된 id를 넣고 출력함
	}

	public void list() { //list 메서드를 실행 , 목록 불러오는 역할
		List<WiseSaying> wiseSayings = wiseSayingService.findAll(); // 서비스클래스 안에 findAll이라는메서드로 받은 어레이리스트 타입의 리턴값을 wiseSayings라는 공간에 담음

		System.out.println("번호  /  작가  /  명언  "); // 출력
		System.out.println("=".repeat(30)); // "="를 30번 반복출력

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 어래이리스트 안에 있는 데이터의 갯수 -1 을 해서 인덱스번호를 정하고 int i에 선언함. i가 0이상인 만큼 반복
			WiseSaying ws = wiseSayings.get(i); // 반복 할 때마다 그 인덱스번호에 맞는 어레이리스트 데이터를 ws 변수에 담음.

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent()); // ws.에 담긴 id, author, content를 출력하고 나면 조건문 성립 될 때 까지 다시 반복해서 출력
		}
	}

	public void remove(Rq rq) { // remove 메서드를 실행하고 rq라는 매개변수를 통해서 rq타입의 데이터를 받음

		int id = rq.getIntParam("id", -1); // "id" 와 -1을 rq.getIntParam메서드한테 넘겨주고, int형 데이터를 담을 id라는 공간에 리턴받은 값을 리턴 받음.

		if (id == -1) { // 조건문.  만약 리턴 받은 값이 defaultValue( -1)라면 아래를 출력
			System.out.println("id(정수)를 제대로 입력해주세요"); // 출력
			return; // 함수끝내
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);// findById라는 함수 통해서 서비스한테 리턴 받은 명언객체를 wiseSaying이라는 객체타입의 변수에 담음

		if (wiseSaying == null) { // 조건문. 만약에 입력된 번호의 객체가 널값이면
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id); // 출력
			return; // 함수끝내
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying); // 서비스한테 찾은 wiseSaying 명언객체를 지워달라고 요청

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id); // findById 파라미터로 받은 id번호를 넣고 출력

	}

	public void modify(Rq rq) { // modify 메서드를실행하고 rq라는 파라미터를 통해서 rq타입의 인자를 받음
		int id = rq.getIntParam("id", -1); // int형 데이터를 담을 공간에, rq클래스에있는 getIntParam이라는메서드로 리턴받은 정수형타입의 defaultValue를 담음

		if (id == -1) { // 조건문.  만약에 defaultValue로받은 id가 -1이라면 아래를 출력
			System.out.println("id(정수)를 제대로 입력해주세요"); // 출력
			return; // 함수끝내
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id); // findById라는 함수로 찾은 명언객체를 wiseSaying이라는 객체타입의 변수에 담음

		if (wiseSaying == null) { // 조건문. 만약에 입력된 번호의 객체가 널값이면
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id); // 출력
			return; // 함수끝내
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent()); // 기존 명언객체에저장되어있던 명언을 게터로(은닉화되어잇으니) 불러와서 출력
		System.out.println("작가(기존) :" + wiseSaying.getAuthor()); // 기존 명언객체에저장되어있던 작가를 게터로(은닉화되어잇으니) 불러와서 출력

		System.out.print("명언 : "); // 출력
		String content = Container.getScanner().nextLine().trim(); // 입력받고 String타입의 content라는 공간에 담음
		System.out.print("작가 : "); // 출력
		String author = Container.getScanner().nextLine().trim(); // 입력받고 Strirng타입의 author이라는 공간에 담음

		wiseSayingService.modify(wiseSaying, content, author); // 방금 입력받고 담은 content와 author 데이터를 덮어씌우기 위해 서비스한테 인자를 던져줌

		System.out.printf("%d번 명언이 수정되었습니다.\n", id); // content와 author 덮어씌운 객체의 번호 넣고 출력
=======
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
>>>>>>> 089193c19ca6f4d5240fb50d02d4f2cb794d2930

	}

}
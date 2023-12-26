package com.ws;

<<<<<<< HEAD
import com.ws.export.controller.ExportController;
import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;
=======
import com.ws.system.controller.SystemController; // SystemController 타입으로 systemController 객체 만들었으니까 import
import com.ws.wiseSaying.controller.WiseSayingController; // WiseSayingController """
>>>>>>> 73c3a69c5417c8991266fe515dd8840da429c183

public class App {

	private byte system_status = 1; // 종료 명령어입력 시 종료가 되지 않고 명령어 받기를 반복하는걸 방지하기 위한 방법. 

	public App() { // App 실행 메서드

	}

	public void run() { // run  실행 메서드
		System.out.println("== 명언 앱 실행 ==");

<<<<<<< HEAD
		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController();
		ExportController exportController = new ExportController();
=======
		SystemController systemController = new SystemController(); // SystemController 클래스로 만든 객체를 systemController 리모콘에 연결
		WiseSayingController wiseSayingController = new WiseSayingController();  // WiseSayingController 클래스로 만든 객체를 wiseSayingController 리모콘에 연결
>>>>>>> 73c3a69c5417c8991266fe515dd8840da429c183

		while (system_status == 1) {  // 만약에 system status가 1이면 아래를 반복적으로 실행해
			System.out.print("명령어 ) "); // 명령어를 출력한다
			String cmd = Container.getScanner().nextLine().trim(); // "명령어"다음에 입력할 수 있도록 해주고 입력받은것을 cmd에 저장한다
			Rq rq = new Rq(cmd); // Rq타입의 객체를 만듬과 동시에 cmd (입력받은 데이터)를 넣을 거야

			switch (rq.getActionCode()) { // 조건문
			case "종료":
				systemController.exit();
				system_status = 0; // system status 조건에일치 하지 않으니 명령어 그만 받고 실행 끝 
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			case "추출":
				exportController.makeHtml(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다"); // 조건문 중에 case에 그 어느것도 해당되지 않으면 출력
				break;
			}
		}

	}
}
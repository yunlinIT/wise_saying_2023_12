package com.ws;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD

		Container.init();

		new App().run();
=======
		
		Container.init(); // Container 클래스에 있는 공유자원을 실행
		
		new App().run(); // App 클래스에 있는 run 메서드를 실행. (new는 객체인데 왜 객체로 만들어서 실행하지? 까먹음)
>>>>>>> 73c3a69c5417c8991266fe515dd8840da429c183

		Container.close(); // Container 클래스에 있는 공유자원을 종료?/??
	}
	
}
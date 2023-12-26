package com.ws;

import java.util.Scanner;

import com.ws.wiseSaying.service.WiseSayingService;

public class Container {
<<<<<<< HEAD

	public static WiseSayingService wiseSayingService;

	static {
		wiseSayingService = new WiseSayingService();
	}

	private static Scanner sc;
=======
	private static Scanner sc; // 여기저기서 입력받을수 있도록 scanner을 공공자원으로 세팅하지만 private
>>>>>>> 73c3a69c5417c8991266fe515dd8840da429c183

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() { // private인 Scanner을 게터로 리턴
		return sc;
	}
}
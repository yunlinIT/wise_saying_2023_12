package com.ws;

import java.util.Scanner;

public class Container {
<<<<<<< HEAD
	private static Scanner sc; // 여기저기서 입력받을수 있도록 scanner을 공공자원으로 세팅하지만 private
=======
	private static Scanner sc;
>>>>>>> 089193c19ca6f4d5240fb50d02d4f2cb794d2930

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

<<<<<<< HEAD
	public static Scanner getScanner() { // private인 Scanner을 게터로 리턴
=======
	public static Scanner getScanner() {
>>>>>>> 089193c19ca6f4d5240fb50d02d4f2cb794d2930
		return sc;
	}
}
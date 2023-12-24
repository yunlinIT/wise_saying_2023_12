package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq { //  Rq 클래스
	private String actionCode; 
	private Map<String, String> params; // Key값과 Value값이 둘다 String타입인 해쉬맵 선언

	public Rq(String cmd) { // 생성자, 객체생성과 동시에 cmd 명령어를 받고 
		String[] cmdBits = cmd.split("\\?", 2); // 받은 명령어를 "?" 기준으로 두조각으로 쪼깨고 그걸 cmdBits 배열안에 담음

		actionCode = cmdBits[0]; // cmdBits배열 0번인덱스(첫번째)의 조각 데이터 ("?" 기준 앞의 명령어) 를 actionCode라는 변수에 담음

		params = new HashMap<>(); // params라는 별명의 해쉬맵 만듬

		if (cmdBits.length == 1) { // 조건문. 만약에 위에서 "?" 기준으로 쪼갠 조각들의 길이가(갯수)가 1개라면, // 예) 명령어가 "?" 이후에 아무것도 안적혀있다면
			return; // 함수 끝내
		}

		String[] paramBits = cmdBits[1].split("&"); // cdmBits배열 1번인덱스(두번째)의 조각 데이터 ("?" 기준 뒤의 명령어)를 "&" 기준으로 쪼갬. "&" 없으면 못쪼개고 그냥 못쪼갠대로 paramBits라는 공간에 넣어.

		for (String paramStr : paramBits) { // paramBits 배열을 for-each문으로 전부 순환해서
			String[] paramStrBits = paramStr.split("=", 2); // "=" 기준으로 또 둘로 쪼개고 paramStrBits 배열에 담음

			if (paramStrBits.length == 1) { // 만약에 paramStrBits의 조각들의 길이가(갯수)가 1이면  
				continue; // 중단하고 반복문 다시 돌기
			}

			String key = paramStrBits[0]; // = 기준 앞에 조각이 key 값
			String value = paramStrBits[1]; // = 기준 뒤에 조각이 value 값
			params.put(key, value); // key, value 값을 params라는 해쉬맵에 저장
		}

	}

	public String getActionCode() { // actionCode가 은닉화되어있어서 게터 함수로 actionCode를 리턴함
		return actionCode;
	}

	public String getParam(String name) { // params가 은닉화되어있어서 게터 함수로 params의 키 값을 매개변수로 받아서 리턴함
		return params.get(name);
	}
	// 제대로된 정수가 입력됐는지 검증하는 메서드인듯... -1사용해서..
	public int getIntParam(String name, int defaultValue) { //getIntParam이라는메서드에 매개변수로 String과 int를 인자로 받음. "id"와  -1받음
		try {
			return Integer.parseInt(getParam(name)); // params에 저장된 String타입의 key값을 int형으로 변환하고 컨트롤러한테 리턴함
		} catch (NumberFormatException e) { // int형으로 변환이 안되는 문제가 발생해서 numberFormatException 에러라면

		}
		return defaultValue; // defaultValue -1을 리턴
	}

}
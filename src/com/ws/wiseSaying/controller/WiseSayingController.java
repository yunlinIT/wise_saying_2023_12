package com.ws.wiseSaying.controller;

import java.util.ArrayList;
import java.util.List;

import com.ws.Container;
import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingController {

	private int lastId;
	private List<WiseSaying> wiseSayings;

	public WiseSayingController() {
		lastId = 0;
		wiseSayings = new ArrayList<>();
	}

	public void write() {
		int id = lastId + 1;
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
		lastId++;

	}

	public void list() {
		if (wiseSayings.size() == 0) {
			System.out.println("등록 된 명언이 없어");
		} else {
			System.out.println("번호  /  작가  /  명언  ");
			System.out.println("=".repeat(30));

			for (int i = wiseSayings.size() - 1; i >= 0; i--) {
				WiseSaying ws = wiseSayings.get(i);

				System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
			}

		}

	}

	public void remove() {
		
	}

}
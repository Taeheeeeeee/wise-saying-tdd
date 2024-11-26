package com.ll.domain.wisesaying.controller;

import com.ll.domain.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private int lastId;
    private List<WiseSaying> list;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.lastId = 0;
        this.list = new ArrayList<>();
    }

    public void actionAdd() {
        System.out.println("명언: ");
        String content = sc.nextLine();
        System.out.println("작가: ");
        String author = sc.nextLine();

        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        list.add(wiseSaying);

        System.out.println(id + "번 명령이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : list.reversed()){
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }
}

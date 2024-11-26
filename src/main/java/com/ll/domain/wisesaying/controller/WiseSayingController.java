package com.ll.domain.wisesaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private int lastId;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.lastId = 0;
    }

    public void actionAdd() {
        System.out.println("명언: ");
        System.out.println("작가: ");
        int id = ++lastId;
        System.out.println(id + "번 명령이 등록되었습니다.");
    }
}

package com.ll.domain.wisesaying.controller;

import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void actionAdd() {
        System.out.println("명언: ");
        System.out.println("작가: ");
    }
}

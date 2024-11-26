package com.ll;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true){
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            if ("종료".equals(cmd)) break;
        }
    }

}

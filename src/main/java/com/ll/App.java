package com.ll;

import com.ll.domain.system.controller.systemController.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final SystemController systemWiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
        this.systemWiseSayingController = new SystemController();
    }

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true){
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            if ("종료".equals(cmd)) {
                systemWiseSayingController.actionExit();
                break;
            }
        }
    }

}

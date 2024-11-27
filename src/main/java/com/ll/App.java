package com.ll;

import com.ll.domain.system.controller.systemController.SystemController;
import com.ll.domain.wisesaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final SystemController systemController;
    private final WiseSayingController wiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Command command = new Command(cmd);

            switch (command.getActionName()) {
                case "종료":
                    systemController.actionExit();
                    return;
                case "등록":
                    wiseSayingController.actionAdd();
                    break;
                case "목록":
                    wiseSayingController.actionList();
                    break;
                case "삭제":
                    wiseSayingController.actionDelete(command);
                    break;
                case "수정":
                    wiseSayingController.actionModify(command);
                    break;
            }
        }
    }
}

package com.ll;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App(new Scanner(System.in));
        app.run();
//        lab1(); // 사람이 직접 입력
//        lab2(); // 자동으로 입력
//        lab3(); // 바로 출력
//        lab4(); // 모아서 출력
    }

    private static void lab1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("명령) ");
        String cmd = sc.nextLine().trim();

        System.out.println("입력한 명령어: " + cmd);
    }

    private static void lab2() {
        InputStream in = new ByteArrayInputStream("hello\ngoodbye".getBytes());

        Scanner sc = new Scanner(in);

        System.out.println("명령) ");
        String cmd = sc.nextLine().trim();

        System.out.println("입력한 명령어: " + cmd);

        System.out.println("명령) ");
        cmd = sc.nextLine().trim();

        System.out.println("입력한 명령어: " + cmd);
    }

    private static void lab3() {
        System.out.println("===시작===");
        System.out.println("안녕");
        System.out.println("===끝===");
    }

    private static void lab4() {
        System.out.println("===시작===");

        // 출력이 모니터로 되지 않게 설정
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕"); // 출력되지 않음

        // 다시 출력이 모니터로 되게 설정
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("===끝===");

        // 모아둔 출력을 한 번에
        System.out.println("출력: "+output.toString());

        // output 자원 해제
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
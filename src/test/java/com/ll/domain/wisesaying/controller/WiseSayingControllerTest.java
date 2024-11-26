package com.ll.domain.wisesaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WiseSayingControllerTest {

    @Test
    @DisplayName("== 명언 앱 ==")
    void t1(){
//        Scanner sc = TestUtil.getScanner("종료");
//        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
//
//        App app = new App(sc);
//        app.run();
//
//        String output = outputStream.toString();
//
//        TestUtil.clearSetOutToByteArray(outputStream);

        String output = AppTest.run("종료");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    void t2(){
//        Scanner sc = TestUtil.getScanner("""
//                목록
//                종료
//                """);
//        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
//
//        App app = new App(sc);
//        app.run();
//
//        String output = outputStream.toString();
//
//        TestUtil.clearSetOutToByteArray(outputStream);
//

        String output = AppTest.run("""
                목록
                종료
                """);

        assertThat(output).contains("명령) ");
    }
}

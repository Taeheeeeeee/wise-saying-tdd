package com.ll.domain.wisesaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WiseSayingControllerTest {

    @Test
    @DisplayName("== 명언 앱 ==")
    void t1(){
        String output = AppTest.run("종료");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    void t2(){
        String output = AppTest.run("""
                목록
                종료
                """);

        assertThat(output).contains("명령) ");
    }
    @Test
    @DisplayName("명령이 두 번이상 입력될 수 있습니다. ")
    void t3(){
        String output = AppTest.run("""
                목록
                목록
                종료
                """);

        String[] split = output.split("명령\\)");

        assertThat(split).hasSize(4);
    }
}

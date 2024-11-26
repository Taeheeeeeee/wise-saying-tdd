package com.ll.domain.wisesaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WiseSayingControllerTest {

    @Test
    @DisplayName("등록을 입력하면 작가와 내용을 입력 받는다.")
    void t4(){
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                장자미상
                """);

        assertThat(output)
                .contains("명언: ")
                .contains("작가: ");
    }

    @Test
    @DisplayName("등록을 완료하면 명언번호가 출력된다.")
    void t5(){
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(output)
                .contains("1번 명령이 등록되었습니다.");
    }
}

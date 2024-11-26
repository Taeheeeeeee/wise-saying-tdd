package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtil 테스트")
    public void t1() {
        Scanner sc = TestUtil.getScanner("""
                등록
                나의 죽음을 적들에게 알리지 말라!
                이순신
                """.stripIndent().trim());

        String cmd = sc.nextLine();
        String content = sc.nextLine();
        String author = sc.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적들에게 알리지 말라!");
        assertThat(author).isEqualTo("이순신");

    }
}
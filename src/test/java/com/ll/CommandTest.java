package com.ll;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {
    @Test
    void t1() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getActionName()).isEqualTo("삭제");
    }

    @Test
    void t2() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("id")).isEqualTo("10");
    }

    @Test
    void t3() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number")).isNull();
    }

    @Test
    void t4() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number", "-")).isEqualTo("-");
    }

    @Test
    void t5() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("id", 0)).isEqualTo(10);
    }

    @Test
    void t6() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("number", 0)).isEqualTo(0);
    }

    @Test
    void t7() {
        Command cmd = new Command("목록?number=10&name=Paul");
        assertThat(cmd.getParamAsInt("number", 0)).isEqualTo(10);
        assertThat(cmd.getParam("name")).isEqualTo("Paul");
    }

    @Test
    void t8() {
        Command cmd = new Command("목록?");
    }
}
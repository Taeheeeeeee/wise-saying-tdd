package domain.wisesaying.controller;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class WiseSayingControllerTest {

    @Test
    @DisplayName("== 명언 앱 ==")
    void t1(){
        Scanner sc = TestUtil.getScanner("종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(sc);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        assertThat(output).contains("== 명언 앱 ==");
    }
}

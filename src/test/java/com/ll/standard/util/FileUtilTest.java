package com.ll.standard.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileUtilTest {
    @BeforeAll
    public static void beforeAll() {
        FileUtil.file.mkdir("temp");
    }

    @AfterAll
    public static void afterAll() {
        FileUtil.file.rmdir("temp");
    }

    @Test
    @DisplayName("파일을 생성할 수 있다.")
    public void t1() {
        String filePath = "temp/test.txt";

        FileUtil.file.touch(filePath);

        assertThat(
                FileUtil.file.exists(filePath)
        ).isTrue();

        FileUtil.file.delete(filePath);
    }

    @Test
    @DisplayName("파일의 내용을 수정할 수 있고, 읽을 수 있다.")
    public void t2() {
        String filePath = "temp/test.txt";

        FileUtil.file.set(filePath, "내용");

        assertThat(
                FileUtil.file.get(filePath, "")
        ).isEqualTo("내용");

        FileUtil.file.delete(filePath);
    }

    @Test
    @DisplayName("파일을 삭제할 수 있다.")
    public void t3() {
        String filePath = "temp/test.txt";

        FileUtil.file.touch(filePath);
        FileUtil.file.delete(filePath);

        assertThat(
                FileUtil.file.notExists(filePath)
        ).isTrue();
    }

    @Test
    @DisplayName("파일을 생성할 수 있다, 만약 해당 경로의 폴더가 없다면 만든다.")
    public void t4() {
        String filePath = "temp/temp/test.txt";

        FileUtil.file.touch(filePath);

        assertThat(
                FileUtil.file.exists(filePath)
        ).isTrue();

        FileUtil.file.delete(filePath);
    }
}
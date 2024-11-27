package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilTest {

    @Test
    @DisplayName("맵을 JSON으로 바꿀 수 있다.")
    void t1(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("맵을 JSON으로 바꿀 수 있다.(필드 2개)")
    void t2(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("맵을 JSON으로 바꿀 수 있다.(숫자 필드)")
    void t3(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("맵을 JSON으로 바꿀 수 있다.(숫자(실수) 필드)")
    void t4(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 189.2323);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 189.2323
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("맵을 JSON으로 바꿀 수 있다.(boolean 필드)")
    void t5(){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 189.2323);
        map.put("married", true);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 189.2323,
                    "married": true
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("JSON을 맵으로 바꿀 수 있다.")
    void t6(){
        String jsonStr = """
                {
                    "name": "이름"
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map).containsEntry("name", "이름");
    }

    @Test
    @DisplayName("JSON to Map(필드 2개)")
    public void t7() {
        String jsonStr = """
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    @DisplayName("JSON to Map(숫자필드(정수))")
    public void t8() {
        // given
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim();

        // when
        Map<String, Object> map = Util.json.toMap(jsonStr);

        // then
        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    @DisplayName("JSON to Map(숫자필드(실수))")
    public void t9() {
        // given
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221
                }
                """.stripIndent().trim();

        // when
        Map<String, Object> map = Util.json.toMap(jsonStr);

        // then
        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자")
                .containsEntry("height", 178.1543221);
    }

    @Test
    @DisplayName("JSON to Map(논리필드)")
    public void t10() {
        // given
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221,
                    "married": false
                }
                """.stripIndent().trim();

        // when
        Map<String, Object> map = Util.json.toMap(jsonStr);

        // then
        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자")
                .containsEntry("height", 178.1543221)
                .containsEntry("married", false);
    }

}

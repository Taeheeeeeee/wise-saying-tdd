package com.ll.standard.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
    public static class file {
        public static void touch(String filePath) {
            set(filePath, "");
        }

        public static boolean exists(String filePath) {
            Path path = Paths.get(filePath);
            return Files.exists(path);
        }

        public static void set(String filePath, String content) {
            Path path = Paths.get(filePath);

            try {
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                final Path parentDir = path.getParent();
                if (parentDir != null && Files.notExists(parentDir)) {
                    try {
                        Files.createDirectories(parentDir);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    throw new RuntimeException(e);
                }
            }
        }

        public static String get(String filePath, String defaultValue) {
            Path path = Paths.get(filePath);

            try {
                return Files.readString(path);
            } catch (IOException e) {
                return defaultValue;
            }
        }

        public static boolean delete(String filePath) {
            final Path path = Paths.get(filePath);

            try {
                Files.walkFileTree(path, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file); // 파일 삭제
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir); // 디렉토리 삭제
                        return FileVisitResult.CONTINUE;
                    }
                });
                return true;
            } catch (NoSuchFileException e) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }

        public static boolean notExists(String filePath) {
            return !exists(filePath);
        }

        public static void mkdir(String dirPath) {
            Path path = Paths.get(dirPath);

            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static boolean rmdir(String dirPath) {
            return delete(dirPath);
        }
    }


    public static class json{
        private json(){

        }

        public static String toString(Map<String, Object> map){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\n");

            map.forEach((key, value) -> {
                sb.append("    ");
                key = "\"" + key + "\"";

                // 문자열일때만 ""
                if(value instanceof String){
                    value = "\"" + value + "\"";
                }

                sb.append("%s: %s,\n".formatted(key, value));
            });

            // 마지막 , 제거
            if(!map.isEmpty()){
                sb.delete(sb.length() -2, sb.length());
            }

            sb.append("\n");
            sb.append("}");

            return sb.toString();

        }

        public static Map<String, Object> toMap(String jsonStr) {
            Map<String, Object> map = new LinkedHashMap<>();

            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);

            String[] jsonStrBits = jsonStr.split(",\n    \"");

            for (String jsonStrBit : jsonStrBits) {
                jsonStrBit = jsonStrBit.trim();

                if (jsonStrBit.endsWith(",")) jsonStrBit = jsonStrBit.substring(0, jsonStrBit.length() - 1);

                String[] jsonField = jsonStrBit.split("\": ");

                String key = jsonField[0];
                if (key.startsWith("\"")) key = key.substring(1);

                boolean valueIsString = jsonField[1].startsWith("\"") && jsonField[1].endsWith("\"");
                String value = jsonField[1];

                if (valueIsString) value = value.substring(1, value.length() - 1);

                if (valueIsString) {
                    map.put(key, value);
                } else if (value.equals("true") || value.equals("false")) {
                    map.put(key, value.equals("true"));
                } else if (value.contains(".")) {
                    map.put(key, Double.parseDouble(value));
                } else {
                    map.put(key, Integer.parseInt(value));
                }
            }

            return map;
        }
    }
}
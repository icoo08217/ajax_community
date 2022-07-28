package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ut {

    private static final ObjectMapper om;

    static {
        om = new ObjectMapper();
    }

    public static class json{
        public static String toStr(Object obj , String defaultValue){
            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> T toObj(String jsonStr, Class<T> cls, T defaultValue ) {
            try {
                return om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> T toObj(String jsonStr, TypeReference<T> typeReference, T defaultValue) {
            try {
                return om.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

//        public static <K,V> Map<K,V> toMap(String jsonStr , TypeReference<Map<K,V>> typeReference , Map<K,V> defaultValue) {
//            try {
//                return om.readValue(jsonStr, typeReference);
//            } catch (JsonProcessingException e) {
//                return defaultValue;
//            }
//        }

    }
    public static Map<String, Object> mapOf(Object... args) {
        Map<String, Object> map = new LinkedHashMap<>();

        int dataSize = args.length / 2;

        for (int i = 0; i < dataSize; i++) {
            int keyIndex = i * 2;
            int valueIndex = i * 2 + 1;

            String key = (String)args[keyIndex];
            Object value = args[valueIndex];

            map.put(key, value);
        }

        return map;

    }
}

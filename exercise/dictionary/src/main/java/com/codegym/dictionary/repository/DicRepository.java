package com.codegym.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DicRepository implements IDicRepository {
    private static Map<String, String> dic;
    static {
        dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
    }

    @Override
    public String findWord(String english) {
        for (String word: dic.keySet()) {
            if(english.equals(word)) {
                return dic.get(word);
            }
        }
        return null;
    }
}

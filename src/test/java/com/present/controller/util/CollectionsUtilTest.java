package com.present.controller.util;

import com.present.model.entities.present_items.IPresentItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 11/08/2018
 */
class CollectionsUtilTest {
    static final List<String> list = new ArrayList<>();
    static final Map<String,Integer> map = new HashMap<>();


    @BeforeAll
    static void setUp(){
        list.add("Ahj");
        list.add(null);
        list.add("");
        list.add("Abc");
        list.add(null);

        map.put("Abc", 5);
        map.put(null, 5);
        map.put(null, 0);
        map.put("ZXC", 0);
        map.put("QWE", 5);
    }

    @Test
    void nullFreeList() {
        List changedList = CollectionsUtil.nullFreeList(list);
        assertEquals(3,changedList.size());
    }

    @Test
    void nullFreeMap() {
        Map changesList = CollectionsUtil.nullFreeMap(map);
        assertEquals(3,changesList.size());
    }

    @Test
    void filledMap() {
        Map changesList = CollectionsUtil.filledMap(map);
        assertEquals(2,changesList.size());
    }
}
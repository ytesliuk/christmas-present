package com.present.controller.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Yuliia Tesliuk on 11/08/2018
 */
public class CollectionsUtil {
    /**
     * Receive a list and return a null-free list
     * @param list list to be filtered
     * @return a null-free list
     */
    public static <T> List<T> nullFreeList(List<T> list){
        return list.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * Receive a map and return a null-free map
     * @param map collection to be filtered
     * @return a null-free map
     */
    public static <K,V> Map<K,V> nullFreeMap(Map<K,V> map){
        return map.entrySet().stream()
                .filter(x -> x.getKey()!=null && x.getValue() != null).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }

    /**
     * Receive a map and return a map were values doesn't equal to zero
     * @param map collection to be filtered
     * @return return a map were values doesn't equal to zero
     */
    public static <K> Map<K,Integer> filledMap(Map<K,Integer> map){
        return map.entrySet().stream()
                .filter(x -> x.getKey()!=null && x.getValue() != null && x.getValue() != 0).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }
}

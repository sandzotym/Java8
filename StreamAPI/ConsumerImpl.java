package com.streamapi;

import java.util.Arrays;
import java.util.List;

public class ConsumerImpl {
    public static void main(String[] args){
        List<Integer> aList = Arrays.asList(1, 2, 3, 4, 5);
        aList.forEach(System.out::println);
    }
}

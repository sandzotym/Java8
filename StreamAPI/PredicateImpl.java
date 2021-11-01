package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateImpl {
    public static void main(String[] args) {
        Predicate<Integer> aPredicate = t -> t%2 == 0;
        System.out.println(aPredicate.test(5));
        List<Integer> aList = Arrays.asList(1, 2, 3, 4, 5);
        aList.stream().filter(t -> t%2 == 0).forEach(t -> System.out.println("Printing Even : " + t));
    }
}

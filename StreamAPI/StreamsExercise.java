package com.streamapi;

import com.employeedb.Database;
import com.employeedb.Employee;

import java.util.*;
import java.util.stream.IntStream;

public class StreamsExercise {
    public static void main(String[] args) {
        List <String> aList = Arrays.asList("abc", "xyz", "sandy");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(3, "efg");
        map.put(2, "xyz");

        //Traditional Snippets

        for(String s:aList) {
            if (s.startsWith("s")) {
                System.out.println(s);
            }
        }

        for(Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }

        //New Snippets

        map.forEach((key, value) -> System.out.println(key + ":" + value));
        map.entrySet().stream().filter(k -> k.getKey()%2 == 0).forEach(System.out::println);

        //Sorting

        List<Integer> numList = new ArrayList<>();
        numList.add(8);
        numList.add(3);
        numList.add(12);
        numList.add(14);

        Collections.sort(numList); //Ascending
        System.out.println(numList);
        //Another way to Sort is using the overloaded method i.e. Collections.sort(List, Comparator)
        numList.sort(new MyComparator());
        System.out.println(numList);

        Collections.reverse(numList);
        System.out.println(numList);

        numList.stream().sorted().forEach(System.out::println);//Ascending
        numList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // Another way is using reversed()

        Database.getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
        Database.getEmployees().stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        //Map to List
        List<Map.Entry<Integer, String>> entriesMapToList = new ArrayList<>(map.entrySet());
        System.out.println(entriesMapToList);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        //Java Parallel Streams Exercise
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Plain Stream took : " + (end-start));

        long startP = 0;
        long endP = 0;
        startP = System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out::println);
        endP = System.currentTimeMillis();
        System.out.println("Parallel Stream took : " + (end-start));

        //Console uses main thread sequentially 1-9
        IntStream.range(1, 10).forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x));

        //Console uses main thread + ForkJoinPool.commonPool -worker -1 : randomly
        IntStream.range(1, 10).parallel()
                .forEach(x -> System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x));

        System.out.println(new Random().nextInt(1000*100)); // Generates random no. in the boundary
        /*This Random Function can be used as a input to create Salary Column in a loop for creating 1000 or more records
        preventing manual effort of creating test data.*/
    }
}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}

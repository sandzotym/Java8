package com.customerdb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDB {
    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101,"Sandy","sgos7@allstate.com", Arrays.asList("8861422264", "9900544411")),
                new Customer(102,"Maneesh","mraoe@allstate.com", Arrays.asList("123456789", "987654321")),
                new Customer(103,"Ramesh","rk299@allstate.com", Arrays.asList("111111111", "222222222")),
                new Customer(104,"Samir","evnxk@allstate.com", Arrays.asList("333333333", "444444444"))
                ).collect(Collectors.toList());
        }
    }

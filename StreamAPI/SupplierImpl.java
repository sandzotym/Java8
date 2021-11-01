package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierImpl {
    public static void main(String[] args){
        Supplier<String> aSupplier = () -> "Hello World";
        System.out.println(aSupplier.get());
        List<String> aList = Arrays.asList("a", "b");
        System.out.println(aList.stream().findAny().orElse("Hello World"));
    }
}

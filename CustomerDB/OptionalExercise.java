package com.customerdb;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExercise {
    public static void main(String[] args) throws Exception {
        Customer customer =
                new Customer(101,"Sandy","sgos7@allstate.com", Arrays.asList("8861422264", "9900544411"));

        Optional<Object> emptyObj = Optional.empty();
        System.out.println(emptyObj); //Optional.empty
        Optional<String> emailOpt = Optional.of(customer.getEmail());
        System.out.println(emailOpt); //NPE if null

        Optional<String> emailOpt1 = Optional.ofNullable(customer.getEmail());

        System.out.println(emailOpt1); //Optional.empty if null else Optional[sgos7@allstate.com]

        if(emailOpt1.isPresent())
            System.out.println(emailOpt1.get());

        System.out.println(emailOpt1.orElse("default"));

        System.out.println(emailOpt1.orElseThrow(() -> new IllegalArgumentException("Not Present")));

        System.out.println(emailOpt1.map(String::toUpperCase).orElse("default"));

        System.out.println(getCustomerByEmail("abc"));
    }

    public static Customer getCustomerByEmail(String email) throws Exception {
        List<Customer> customers = EkartDB.getAll();
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny().orElseThrow(() -> new Exception("No Customer Present with this EmailID"));
    }
}

package com.customerdb;

import com.employeedb.Database;
import com.employeedb.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = EkartDB.getAll();

        //List<Customer> convert List<String> -> Data Transformation
        //customer -> customer.getEmail() ---- 1:1 Mapping
        List<String> emails = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhoneNumbers()  ---- 1:Many Mapping
        List<String> phoneNumbers =
                customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //Map-Reduce Exercise
        Integer sum = Stream.of(2, 4, 6).reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> num = Arrays.asList(1, 2, 3);
        int sum1 = num.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        Optional<Integer> reduceSumWithMethodRef = num.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodRef);

        Optional<Integer> reduceSumWithMethodRef1 = num.stream().reduce(Integer::max);
        System.out.println(reduceSumWithMethodRef1);

        /* Average Salary of Grade A - Code
         - get Employee with Grade A
         - get Salary
         */
        double avgSal = Database.getEmployees().stream() //Stream<Employee>
                .filter(emp -> emp.getGrade().equalsIgnoreCase("A")) //Stream<Employee>
                .map(Employee::getSalary) //Stream<Double>
                .mapToDouble(i -> i) // Double Stream
                .average().getAsDouble();
        System.out.println(avgSal);
    }
}

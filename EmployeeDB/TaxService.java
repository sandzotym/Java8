package com.employeedb;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {
    public static List<Employee> evaluateTaxUsers(String input){
        return (input.equalsIgnoreCase("tax"))
                ?Database.getEmployees().stream().filter(emp -> emp.getSalary() > 500000).collect(Collectors.toList())
                :Database.getEmployees().stream().filter(emp -> emp.getSalary() <= 500000).collect(Collectors.toList());
                //collect(Collectors.toList()) converts o/p to List/Sets etc.
    }

    public static void main(String[] args){
        System.out.println(evaluateTaxUsers("tax"));
    }
}

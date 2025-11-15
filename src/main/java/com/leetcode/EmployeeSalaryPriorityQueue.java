package com.leetcode;

import java.util.PriorityQueue;
import java.util.Comparator;

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class EmployeeSalaryPriorityQueue {
    public static void main(String[] args) {
        // 🔹 Comparator for salary (ascending order → lowest salary first)
        Comparator<Employee> salaryComparatorAsc =
                Comparator.comparingInt(Employee::getSalary);

        // 🔹 Comparator for salary (descending order → highest salary first)
        Comparator<Employee> salaryComparatorDesc =
                (e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary());

        // You can switch between ascending and descending comparator here
        PriorityQueue<Employee> pq = new PriorityQueue<>(salaryComparatorDesc);

        pq.add(new Employee("Alice", 50000));
        pq.add(new Employee("Bob", 70000));
        pq.add(new Employee("Charlie", 60000));
        pq.add(new Employee("David", 40000));

        System.out.println("Employees ordered by salary (highest first):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}


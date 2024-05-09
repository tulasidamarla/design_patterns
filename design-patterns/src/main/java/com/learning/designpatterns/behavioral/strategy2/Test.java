package com.learning.designpatterns.behavioral.strategy2;

import com.learning.designpatterns.behavioral.strategy2.strategy.AdultFilter;
import com.learning.designpatterns.behavioral.strategy2.strategy.MarriageFilter;
import com.learning.designpatterns.behavioral.strategy2.strategy.SeniorFilter;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args){
        List<Person> people = Arrays.asList(
                new Person("Doe", 20, false),
                new Person("Smith", 30, true),
                new Person("Old", 70, true)
        );
        var counter = new PeopleCountService();
        counter.setFilter(new AdultFilter());
        System.out.println("Adult count is " + counter.count(people)); // count: 3

        counter.setFilter(new SeniorFilter());
        System.out.println("Senior citizen count is " + counter.count(people)); // count: 1

        counter.count(people); // Senior count: 1

        counter.setFilter(new MarriageFilter());
        System.out.println("Married people count is " + counter.count(people)); // count: 2
    }
}

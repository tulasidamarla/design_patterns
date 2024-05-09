package com.learning.designpatterns.behavioral.strategy2.strategy;

import com.learning.designpatterns.behavioral.strategy2.Person;

public class AdultFilter implements PersonFilter {
    public boolean apply(Person person){
        if(person.getAge() >= 18){
            return true;
        }
        return false;
    }
    // Implement Adult filter
}


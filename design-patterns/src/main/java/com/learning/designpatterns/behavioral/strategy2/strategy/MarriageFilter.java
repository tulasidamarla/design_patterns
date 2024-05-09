package com.learning.designpatterns.behavioral.strategy2.strategy;

import com.learning.designpatterns.behavioral.strategy2.Person;

public class MarriageFilter implements PersonFilter {
    public boolean apply(Person person){
        if(person.isMarried()){
            return true;
        }
        return false;
    }
    // Implement Adult filter
}


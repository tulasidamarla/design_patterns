package com.learning.designpatterns.behavioral.strategy2.strategy;

import com.learning.designpatterns.behavioral.strategy2.Person;

public interface PersonFilter {
    boolean apply(Person person);
}
package com.learning.designpatterns.behavioral.strategy2;

import com.learning.designpatterns.behavioral.strategy2.strategy.PersonFilter;

import java.util.List;

public class PeopleCountService {
    private PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }

    public int count(List<Person> people) {
        int count = 0;
        for(Person person: people){
            if(filter.apply(person)){
                count += 1;
            }
        }
        return count;
    }
}

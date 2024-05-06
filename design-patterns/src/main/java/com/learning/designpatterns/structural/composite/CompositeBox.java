package com.learning.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeBox implements Box{
    private final List<Box> children = new ArrayList<>();

    public CompositeBox(Box... boxes) {
        children.addAll(List.of(boxes));
    }

    @Override
    public double calculatePrice() {
        return children
                .stream()
                .mapToDouble(Box::calculatePrice)
                .sum();
    }
}

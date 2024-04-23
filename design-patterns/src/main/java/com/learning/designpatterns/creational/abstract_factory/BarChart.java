package com.learning.designpatterns.creational.abstract_factory;

import java.util.List;

public class BarChart implements Chart{

    @Override
    public List<Double> getData() {
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void setData(List<Double> data) {
        throw new UnsupportedOperationException("Unimplemented method 'setData'");
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public void generateImage() {
        throw new UnsupportedOperationException("Unimplemented method 'generateImage'");
    }
    
}

package com.learning.designpatterns.creational.abstractfactory;

import java.util.List;

public interface Chart {
  List<Double> getData();
  void setData(List<Double> data);
  String getType();
  void generateImage();
}

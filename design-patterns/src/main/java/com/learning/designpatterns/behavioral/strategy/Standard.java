package com.learning.designpatterns.behavioral.strategy;

public class Standard implements Openable {

    public void open() {
      System.out.println("Pushing door open");
    }
  
    public void close() {
      System.out.println("Pulling door closed");
    }
  }
  

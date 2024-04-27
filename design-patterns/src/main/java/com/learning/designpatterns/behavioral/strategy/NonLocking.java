package com.learning.designpatterns.behavioral.strategy;

public class NonLocking implements Lockable {

    public void lock() {
      System.out.println("Door does not lock - ignoring");
    }
  
    public void unlock() {
      System.out.println("Door cannot unlock because it cannot lock");
    }
  }
  

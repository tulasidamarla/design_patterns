package com.learning.designpatterns.behavioral.strategy;

public class Password implements Lockable {

    public void lock() {
      System.out.print("Door locked using password!");
    }
  
    public void unlock() {
      System.out.print("Door unlocked using password!");
    }
  }
  

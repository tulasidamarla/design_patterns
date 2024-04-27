package com.learning.designpatterns.behavioral.strategy;

public abstract class Door {

    private Lockable lockBehavior;
    private Openable openBehavior;
  
    public void setLockBehavior(Lockable l) {
      this.lockBehavior = l;
    }
  
    public void setOpenBehavior(Openable o) {
      this.openBehavior = o;
    }
  
    public void performLock() {
      lockBehavior.lock();
    }
  
    public void performUnlock() {
      lockBehavior.unlock();
    }
  
    public void performOpen() {
      openBehavior.open();
    }
  
    public void performClose() {
      openBehavior.close();
    }
  
    public float getDimensions() {
      return 5;
    }
  }
  

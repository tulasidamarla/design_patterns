package com.learning.designpatterns.behavioral.visitor.example2;

public class Operand implements Expression {
    private final int value;
  
    public Operand(int value) {
      this.value = value;
    }
  
    @Override
    public int accept(Evaluator visitor) {
      return visitor.visitOperand(this);
    }
  
    public int getValue() {
      return value;
    }
  }

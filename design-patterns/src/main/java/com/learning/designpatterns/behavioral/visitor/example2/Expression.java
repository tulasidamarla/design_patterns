package com.learning.designpatterns.behavioral.visitor.example2;

public interface Expression {
    int accept(Evaluator visitor);
  }

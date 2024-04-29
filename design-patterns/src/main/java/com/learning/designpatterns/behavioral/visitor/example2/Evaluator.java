package com.learning.designpatterns.behavioral.visitor.example2;

public interface Evaluator {
    int visitBinaryExpression(BinaryExpression expression);
    int visitOperand(Operand operand);
  }

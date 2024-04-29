package com.learning.designpatterns.behavioral.visitor.example2;

public class ArithmeticEvaluator implements Evaluator {
    @Override
    public int visitBinaryExpression(BinaryExpression expression) {
        
      int leftValue = expression.getLeft().accept(this); // Recursively evaluate left operand
      int rightValue = expression.getRight().accept(this); // Recursively evaluate right operand
      int result = 0;
      switch (expression.getOperator()) {
        case "+":
          result = leftValue + rightValue;
          break;
        case "-":
          result = leftValue - rightValue;
          break;
        // Implement other operators...
      }
      // Handle the result (e.g., print or store)
      System.out.println("Result: " + result);
      return result;
    }
  
    @Override
    public int visitOperand(Operand operand) {
      // Access the operand value (which is already known)
      System.out.println("Operand: " + operand.getValue());
      return operand.getValue();
    }
  }

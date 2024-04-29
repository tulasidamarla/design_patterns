package com.learning.designpatterns.behavioral.visitor.example2;

public class Test {

    public static void main(String[] args) {
        // System.out.println("--------------------------");
        // testComplexExpression();
        // System.out.println("--------------------------");
        // testSimpleExpression();
        // System.out.println("--------------------------");
    Expression left = new Operand(5);
    Expression right = new Operand(3);
    Expression expression = new BinaryExpression(left, right, "+");

    Evaluator evaluator = new ArithmeticEvaluator();
    expression.accept(evaluator);
    }

    
  public static void testSimpleExpression() {
    Expression left = new Operand(5);
    Expression right = new Operand(3);
    Expression expression = new BinaryExpression(left, right, "+");

    Evaluator evaluator = new ArithmeticEvaluator();
    expression.accept(evaluator);
  }

  
  public static void testComplexExpression() {
    Expression left = new BinaryExpression(new Operand(10), new Operand(2), "*");
    Expression right = new Operand(4);
    Expression expression = new BinaryExpression(left, right, "-");

    Evaluator evaluator = new ArithmeticEvaluator();
    expression.accept(evaluator);
  }
    
}

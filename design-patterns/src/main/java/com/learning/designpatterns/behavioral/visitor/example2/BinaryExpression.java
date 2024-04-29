package com.learning.designpatterns.behavioral.visitor.example2;

public class BinaryExpression implements Expression {
    private final Expression left;
    private final Expression right;
    private final String operator; // +, -, *, etc.
  
    public BinaryExpression(Expression left, Expression right, String operator) {
      this.left = left;
      this.right = right;
      this.operator = operator;
    }
  
    @Override
    public int accept(Evaluator visitor) {
      return visitor.visitBinaryExpression(this);
    }
  
    public Expression getLeft() {
      return left;
    }
  
    public Expression getRight() {
      return right;
    }
  
    public String getOperator() {
      return operator;
    }
  }

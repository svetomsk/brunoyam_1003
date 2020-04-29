package oop_practice;

import java.util.HashMap;
import java.util.Map;

public class Expression {
    public double calculate(Map<String, Double> variableToValue) {
        return 0;
    }

    public String covertToString() {
        return "";
    }
}

class Plus extends Expression {
    String symbol = "+";
    Expression left;
    Expression right;

    public Plus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double calculate(Map<String, Double> variableToValue) {
        double leftValue = left.calculate(variableToValue);
        double rightValue = right.calculate(variableToValue);
        return leftValue + rightValue;
    }
}

class Minus extends Expression{

    public Minus(Expression left, Expression right) {
    }
}

class Multiply extends Expression {
    public Multiply(Expression left, Expression right) {
    }
}

class Division extends Expression {
    public Division(Expression left, Expression right) {

    }
}

class Const extends Expression {
    double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double calculate(Map<String, Double> variableToValue) {
        return value;
    }
}

class Var extends Expression {
    String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public double calculate(Map<String, Double> variableToValue) {
        return variableToValue.getOrDefault(name, 1.0);
    }
}

class Test {
    // expression without brackets parsing
    public static Expression parseExpression(String value) {
        value = value.trim();
        // find operation
        int operationIndex = value.indexOf('+');
        if (operationIndex != -1) {
            Expression leftPart = parseExpression(value.substring(0, operationIndex));
            Expression rightPart = parseExpression(value.substring(operationIndex + 1));
            return new Plus(leftPart, rightPart);
        }
        operationIndex = value.indexOf("-");
        if (operationIndex != -1) {
            Expression leftPart = parseExpression(value.substring(0, operationIndex));
            Expression rightPart = parseExpression(value.substring(operationIndex + 1));
            return new Minus(leftPart, rightPart);
        }
        operationIndex = value.indexOf("*");
        if (operationIndex != -1) {
            Expression leftPart = parseExpression(value.substring(0, operationIndex));
            Expression rightPart = parseExpression(value.substring(operationIndex + 1));
            return new Multiply(leftPart, rightPart);
        }
        operationIndex = value.indexOf("/");
        if (operationIndex != -1) {
            Expression leftPart = parseExpression(value.substring(0, operationIndex));
            Expression rightPart = parseExpression(value.substring(operationIndex + 1));
            return new Division(leftPart, rightPart);
        }

        try {
            return new Const(Double.parseDouble(value));
        } catch (Exception exc) {
            return new Var(value);
        }
    }

    public static void main(String[] args) {
        // x + 15
        Var x = new Var("x");
        Const ten = new Const(10);
        Const fifteen = new Const(15);
        Plus sum = new Plus(x, fifteen);
        Map<String, Double> variableToValue = new HashMap<>();
        // "x" - 25
        variableToValue.put("x", 28.0);
        System.out.println(sum.calculate(variableToValue));
        System.out.println(sum.covertToString());

        String expression = "x + 2 - 3 * 4 + 10 / 5";
        System.out.println(parseExpression(expression).calculate(variableToValue));
    }
}





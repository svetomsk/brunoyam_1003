package oop_practice.expression;

import com.sun.source.tree.ExpressionStatementTree;

import java.util.HashMap;
import java.util.Map;

// полностью асбтрактный класс
interface AbstractExpression {
    double calculate(Map<String, Double> values);
    String convertToString();
}

public abstract class Expression {
    // функция без реализации, абстрактная функция
    public abstract double calculate(Map<String, Double> variableToValue);

    public abstract String convertToString();
}

// Expression s = new Expression();
// s.calculate(null); --  FAIL
// s.covertToString(); -- OK

abstract class BinaryOperation extends Expression {
    protected String symbol;
    protected Expression left;
    protected Expression right;

    public BinaryOperation(String symbol, Expression left, Expression right) {
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    @Override
    public String convertToString() {
        return "";
    }

    @Override
    public double calculate(Map<String, Double> variableToValue) {
        double leftValue = left.calculate(variableToValue);
        double rightValue = right.calculate(variableToValue);
        return operation(leftValue, rightValue); // leftValue ?? rightValue
    }

    public abstract double operation(double a, double b);
}

class Plus extends BinaryOperation {
    public Plus(Expression left, Expression right) {
        super("+", left, right);
    }

    @Override
    public double operation(double a, double b) {
        return a + b;
    }

    // new Plus();
//    String symbol = "+";
//    Expression left;
//    Expression right;
//
//    public Plus(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public double calculate(Map<String, Double> variableToValue) {
//        double leftValue = left.calculate(variableToValue);
//        double rightValue = right.calculate(variableToValue);
//        return leftValue + rightValue;
//    }

}

class Minus extends BinaryOperation {
    public Minus(Expression left, Expression right) {
        super("-", left, right);
    }

    @Override
    public double operation(double a, double b) {
        return a - b;
    }

    //    String symbol = "-";
//    Expression left;
//    Expression right;
//
//    public Minus(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public double calculate(Map<String, Double> variableToValue) {
//        double leftValue = left.calculate(variableToValue);
//        double rightValue = right.calculate(variableToValue);
//        return leftValue - rightValue;
//    }
}

class Multiply extends BinaryOperation {
    public Multiply(Expression left, Expression right) {
        super("*", left, right);
    }

    @Override
    public double operation(double a, double b) {
        return a * b;
    }
}

class Division extends BinaryOperation {
    public Division(Expression left, Expression right) {
        super("/", left, right);
    }

    @Override
    public double operation(double a, double b) {
        return a / b;
    }
}

class Pow extends BinaryOperation {
    public Pow(Expression left, Expression right) {
        super("^", left, right);
    }

    @Override
    public double operation(double a, double b) {
        return Math.pow(a, b);
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

    @Override
    public String convertToString() {
        return Double.toString(value);
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

    @Override
    public String convertToString() {
        return name;
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
        Expression sum = new Plus(x, fifteen);
        Map<String, Double> variableToValue = new HashMap<>();
        // "x" - 25
        variableToValue.put("x", 28.0);
        System.out.println(sum.calculate(variableToValue));
//        System.out.println(sum.covertToString());

        String expression = "x + 2 - 3 * 4 + 10 / 5";
//        Comparable
//        Serializable

        System.out.println(parseExpression(expression).calculate(variableToValue));
    }
}





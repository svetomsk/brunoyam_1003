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

class Minus {

}

class Multiply {

}

class Division {

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
    public static void main(String[] args) {
        // x + 15
        Var x = new Var("x");
        Const ten = new Const(10);
        Const fifteen = new Const(15);
        Expression sum = new Plus(x, fifteen);
        Map<String, Double> variableToValue = new HashMap<>();
        // "x" - 25
        variableToValue.put("x", 25.0);
        System.out.println(sum.calculate(variableToValue));
        System.out.println(sum.covertToString());
    }
}





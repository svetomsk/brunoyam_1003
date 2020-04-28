package oop;

import java.util.ArrayList;
import java.util.List;

class Shape {
    public double square() {
        return 0;
    }
}

class Square extends Shape {
    int a;

    public Square(int a) {
        this.a = a;
    }

    public double square() {
        return a * a;
    }
}

class Circle extends Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    public double square() {
        return Math.PI * r * r;
    }
}

class Triangle extends Shape {
    int a;
    int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override // аннотация переопределения
    public double square() {
        return a * h;
    }
}


public class ShapesExample {
    public static void main(String[] args) {
        Square sq1 = new Square(1);
        Square sq2 = new Square(2);
        Shape sq3 = new Square(3);

        Shape circle1 = new Circle(1);
        Circle circle2 = new Circle(2);
        Triangle tr = new Triangle(2, 5);
        tr.square();

        List<Shape> figures = new ArrayList<>();
        figures.add(sq1);
        figures.add(sq2);
        figures.add(sq3);
        figures.add(circle1);
        figures.add(circle2);

        double sumOfSquares = 0;
        for(Shape shape : figures) {
            sumOfSquares += shape.square();
        }
        System.out.println(sumOfSquares);

        List<Object> shapes = new ArrayList<>();
        shapes.add(sq1);
        shapes.add(sq2);
        shapes.add(sq3);
        shapes.add(circle1);
        shapes.add(circle2);

        double sum = 0;
        for(Object current : shapes) {
            if (current instanceof Square) { // проверяем тип объекта
                Square tmp = (Square) current;
                sum += tmp.square();
            }
            if (current instanceof Circle) {
                Circle tmp = (Circle) current;
                sum += tmp.square();
            }
        }
        System.out.println(sum);
    }
}

package oop;

class Ratio {// extends Object // обыкновенная дробь a/b
    private int a; // числитель
    private int b; // знаменатель

    // getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    // setters
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        this.b = b;
    }

    public Ratio(int aa, int bb) {
        if (bb == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        a = aa;
        b = bb;
    }

    public Ratio add(Ratio other) { // a/b + c/d
        int newA = a * other.b + b * other.a; // числитель
        int newB = b * other.b; // знаменателя
        Ratio result = new Ratio(newA, newB);
        return result;
    }

    public double toDouble() {
        return (double) a / b;
    }
}

public class IncapsExample {
    public static void main(String[] args) {
        Ratio half = new Ratio(1, 2); // 1/2
        Ratio quaret = new Ratio(1, 4); // 1/4
        Ratio wrongRatio = new Ratio(2, 1);
        System.out.println(wrongRatio.toDouble());
        Ratio sum = half.add(quaret); // 1/2 + 1/4 = 3/4
        System.out.println(sum.toDouble());

        sum.setA(5); // sum.a = 5;
        sum.setB(10); // sum.b = 10;
        System.out.println(sum.toDouble());

    }
}

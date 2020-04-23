package oop;

import java.util.ArrayList;
import java.util.List;

class Parent { // extends Object
    int a;
    int b;
    int c;

    public int calcSum() {
        return a + b + c;
    }
}

class Child1 extends Parent {
    int d;
    int e;
}


class Child2 extends Parent {
    int d;
    int e;
}

public class InheritanceExample {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.a = 1;
        p.b = 2;
        p.c = 3;
        Child1 child = new Child1();
        child.a = 4;
        child.b = 4;
        child.c = 4;
        child.d = 4;
        child.e = 4;

        List<Parent> list = new ArrayList<>();
        list.add(new Child1());
        list.add(new Child2());

    }
}

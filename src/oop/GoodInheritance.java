package oop;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(name + " is walking");
    }

//    protected void someAction() {
//
//    }
}

class Dog extends Animal {

    public Dog() {
        super("Dog");
    }

    public void bark() {
        System.out.println("I'm barking");
//        someAction();
    }
}


public class GoodInheritance {
    public static void main(String[] args) {
        Animal dog = new Animal("dog");
        Animal cat = new Animal("cat");
        dog.walk();
        cat.walk();

        Dog dg = new Dog();
        dg.walk();
        dg.bark();

        // Animal god = new Dog(); -- разрешено
        // Dog dog = new Animal(); -- запрещено
    }
}

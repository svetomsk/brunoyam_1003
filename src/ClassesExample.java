class Car {
    // поля класса
    String model;
    int year;
    String color;
    int maxVelocity;
//    boolean worthSxpending;

    // конструктор класса
    // конструктор по умолчанию (без аргументов)
    public Car() {
        System.out.println("car was created");
    }

    // заполняем значения полей
    // подготовливаем класс к работе
    public Car(String carModel, int yearOfCreation, String carColor, int velocity) {
        model = carModel;
        year = yearOfCreation;
        color = carColor;
        maxVelocity = velocity;
    }

    public Car(String carModel, int yearOfCreate) {
        model = carModel;
        year = yearOfCreate;
        color = "black";
        maxVelocity = 200;
    }


}


public class ClassesExample {
    public static void main(String[] args) {
        String color = "black";
        Car audi = new Car("audi", 2008, "blue", 230);
//        audi.color = "blue";
//        audi.year = 2008;
//        audi.maxVelocity = 230;
//        audi.model = "audi";

        Car bmw = new Car("bmw", 2010, "black", 240);
//        bmw.model = "bmw";
//        bmw.year = 2010;
//        bmw.maxVelocity = 240;
//        bmw.color = "black";
        Car zhiguli = new Car("vas2101", 2010);
        System.out.println(audi.year);
    }
}

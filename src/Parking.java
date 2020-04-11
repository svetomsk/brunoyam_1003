public class Parking {
    String [] parking;
    int size;

    public Parking(int n) {
        size = n;
        parking = new String[size];
    }

    public void addCar(String number) {

    }

    public void freeCar(String number) {

    }

    public void show() {

    }

    public int freePlaces() {
        return 0;
    }
}

class TestParking {
    public static void main(String[] args) {
        Parking p = new Parking(10);
        p.addCar("a123bc");
        p.show();

        p.addCar("b321ef");
        p.show();
        System.out.println(p.freePlaces());

        p.freeCar("a123bc");
        p.show();
    }
}

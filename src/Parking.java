import java.util.Arrays;

public class Parking {
    String [] parking;
    int size;

    public Parking(int n) {
        size = n;
        parking = new String[size];
        for (int i = 0; i < n; i++) {
            parking[i] = "";
        }
    }

    public void addCar(String number) {
        int pos = firstFreePlace();
        parking[pos] = number;
    }

    private int firstFreePlace() {
        for (int i = 0; i < size; i++) {
            if(parking[i].equals("")) { // !parking[i].isEmpty()
               return i;
            }
        }
        return -1;
    }

    public void freeCar(String number) {

    }

    public void show() {
        System.out.println(Arrays.toString(parking));
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

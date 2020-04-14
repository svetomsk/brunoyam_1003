import java.util.Arrays;

public class Parking {
    String [] parking;
    int size;

    public Parking(int n) {
        size = n;
        parking = new String[size];
        // [null, null, ...]
        for (int i = 0; i < n; i++) {
            parking[i] = "";
        }
        // ["", "", "", ...]
//        parking[i].equals("")
    }

    public void addCar(String number) {
        int pos = firstFreePlace();
        parking[pos] = number;
    }

    private int firstFreePlace() {
        for (int i = 0; i < size; i++) {
            if(this.parking[i].equals("")) { // !parking[i].isEmpty()
               return i;
            }
        }
        return -1;
    }

    public void freeCar(String number) {
        for (int i = 0; i < size; i++) {
            if (parking[i].equals(number)) {
                parking[i] = "";
            }
        }
    }

    public void show() {
        System.out.println(Arrays.toString(parking));
    }

    public int freePlaces() {
        int count = 0;
        for(String element : parking) {
            if(element.equals("")) {
                count++;
            }
        }
        return count;
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
        p.freeCar("b321ef");
        p.show();
        System.out.println(p.freePlaces());
    }
}

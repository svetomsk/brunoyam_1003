import java.util.Arrays;

public class Parking {
    // без final изменяемая
//    String EMPTY_PLACE = "__";
    // c final неизменяемая
    final String EMPTY_PLACE = "__";
    String [] parking;
    int size;

    public Parking(int n) {
        size = n;
        parking = new String[size];
        // [null, null, ...]
        for (int i = 0; i < n; i++) {
            parking[i] = EMPTY_PLACE;
        }
        // ["", "", "", ...]
//        parking[i].equals("")
    }

    public void addCar(String number) {
        int pos = firstFreePlace();
        // проверка наличия свободного места
        if (pos != -1) {
            parking[pos] = number;
        } else {
            System.out.println("No free places");
        }
    }

    private int firstFreePlace() {
        for (int i = 0; i < size; i++) {
            if(this.parking[i].equals(EMPTY_PLACE)) { // !parking[i].isEmpty()
               return i;
            }
        }
        return -1;
    }

    public void freeCar(String number) {
        for (int i = 0; i < size; i++) {
            if (parking[i].equals(number)) {
                parking[i] = EMPTY_PLACE;
            }
        }
    }

    public void show() {
        System.out.println(Arrays.toString(parking));
    }

    public int freePlaces() {
        int count = 0;
        for(String element : parking) {
            if(element.equals(EMPTY_PLACE)) {
                count++;
            }
        }
        return count;
    }
}

class TestParking {
    public static void main(String[] args) {
        Parking p = new Parking(1);
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

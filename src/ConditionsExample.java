public class ConditionsExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 7;
        System.out.println(a > b);
//        if (a > b) {
//            System.out.println(a);
//        } else {
//            System.out.println(b);
//        }
//
//        if(a > 5)
//            System.out.println("yes");
//
//        boolean check = false;
//        check = true;




        int x = -12;
        boolean left = x < -10;
        if(left) {
            System.out.println("left");
        } else {
            if(x > 10) {
                System.out.println("right");
            } else {
                System.out.println("center");
            }
        }

        if(left) {
            System.out.println("left");
        } else if(x > 10) {
            System.out.println("right");
        } else {
            System.out.println("center");
        }
    }
}

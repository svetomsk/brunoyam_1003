package hw;

public class HW2 {
    public static void main(String[] args) {
        String number1 = "123";
        String number2 = "10";
        int num1 = Integer.valueOf(number1);
        int num2 = Integer.valueOf(number2);
        if (num2 != 0 && num1 % num2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


        int numA = 12;
        int numB = 5;
        double a = numA;
        double b = numB;
        System.out.println(a / b);

        System.out.println((double) numA / numB);


        System.out.println('a');
        System.out.println((int)'a');
        System.out.println((int)'b');
        System.out.println((int)'z');
        System.out.println((int)'A');
        String value = "6ello";
        if(value.charAt(0) >= 'A' && value.charAt(0) <= 'Z') {
            System.out.println("Yes");
        } else
            System.out.println("No");

        if(Character.isUpperCase(value.charAt(0))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        value = "hello";
        char firstSymbol = value.charAt(0);
        if (Character.isLowerCase(firstSymbol)) {
            String result = Character.toUpperCase(firstSymbol) + value.substring(1);
            System.out.println(result);
        } else {
            System.out.println(value);
        }


        String numberString = "12";
        int firstDigit = Character.getNumericValue(numberString.charAt(0));
        int secondDigit = Character.getNumericValue(numberString.charAt(1));
        System.out.println(firstDigit + secondDigit);

//        char result = Character.toLowerCase('B');
//        System.out.println(result);
        int aa = 13;
        int bb = 10;
        int cc = 7;
        if (aa % 2 != 0) {
            aa = 0;
        } else{
            aa = aa;
        }

        aa = (aa % 2 != 0) ? 0 : aa;
        bb = (bb % 2 != 0) ? 0 : bb;
        cc = (cc % 2 != 0) ? 0 : cc;

        System.out.println(Math.max(aa, Math.max(bb, cc)));


        if(aa * aa + bb * bb == cc * cc) {

        }
        if(Math.pow(aa, 2) + Math.pow(bb, 2) == Math.pow(cc, 2)) {

        }
    }
}

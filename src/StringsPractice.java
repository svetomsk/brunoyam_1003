public class StringsPractice {
    // psvm
    public static void main(String[] args) {
        String name = "aaaaaaaaaaaaaaaaaaaaaaaaaab";
        // #1 Дана строка, нужно получить и напечатать новую строку,
        // в которой первый и последний символ поменяны местами.
        // "abcd" -> "dbca"

        char firstSymbol = name.charAt(0);
        char lastSymbol = name.charAt(name.length() - 1);
        String between  = name.substring(1, name.length() - 1);
        String result = lastSymbol + between + firstSymbol;
        System.out.println(result);

        // #2 Дана строка, проверить, что число в ней делится на 3
        // "123" -> yes
        String number = "123";
        int value = Integer.valueOf(number);
        if (value % 3 == 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        // #3 Дана строка из шести цифр. Проверить, что сумма первых трех
        // совпадает с суммой последних трех.
        // "546970" -> yes
        // "123456" -> no
    }
}

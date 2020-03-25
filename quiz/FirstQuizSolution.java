public class FirstQuizSolution {
    public static void main(String[] args) {
        int age = 24;
        // проверить, зная возраст, что человек совершеннолетний
        if(age >= 18) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String name = "Svetozar";
        // напечатать длину имени
        System.out.println("Количество букв в имени " + name + " = " + name.length());

        String phone = "+79998887766";
        // проверить, что телефон начинается с кода +7 и состоит из 10 цифр
        if(phone.charAt(0) == '+' && phone.charAt(1) == '7' && phone.length() - 2 == 10) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String patronymic = "Ivanovich";
        // составить строчку из фамилии и инициалов: Ivanov I. I.
        String fullName = lastName + " " + firstName.charAt(0) + ". " + patronymic.charAt(0) + ".";
        System.out.println(fullName);
    }
}

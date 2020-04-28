package hw;

public class HW5 {
    static boolean checkAllLowerCase(String value) {
        boolean result = true;
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            // if(!Character.isLowerCase(current)) {
            if (!(current >= 'a' && current < 'z')) {
                result = false;
                break;
            }
        }
        return result;
    }

    static int countPositiveElements(int[] value) {
        int result = 0;
        for (int element : value) {
            if (element > 0) {
                result++;
            }
        }
        return result;
    }

    static boolean checkPalindrom(String value) {
        boolean result = true;
        for (int i = 0; i < value.length(); i++) {
            int left = i;
            int right = value.length() - 1 - i;
            if (value.charAt(left) != value.charAt(right)) {
                result = false;
                break;
            }
        }
        return result;
    }

    static boolean anotherCheckPalindrom(String value) {
        for (int i = 0; i < value.length(); i++) {
            int left = i;
            int right = value.length() - 1 - i;
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "somRstring";
        System.out.println(checkAllLowerCase(test));

        int[] mas = {1, -2, 3, -4};
        System.out.println(countPositiveElements(mas));

        System.out.println(checkPalindrom("abba"));
        System.out.println(anotherCheckPalindrom("abba"));
    }
}

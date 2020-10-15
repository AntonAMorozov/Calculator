package Calc;

public class RomanToArabic {
    public static int rTA (String arabic) {
        int result = 0;
        int[] decimal = {10, 9, 5, 4, 1};
        String[] roman = {"X", "IX", "V", "IV", "I"};
        for (int i = 0; i < decimal.length; i++) {
            while (arabic.indexOf(roman[i]) == 0) {
                result += decimal[i];
                arabic = arabic.substring(roman[i].length());
            }
        }
        return result;
    }

}
package Calc;

import java.util.Scanner;

public class Calc {

    private static boolean arabicNumber = true;


    public static  void sum (int a, int b) {
        int s = a + b;
        if (arabicNumber) {
        System.out.println("Ответ: " + s);}
        else {
            System.out.println("Ответ: " + ArabicToRoman.aRT(s));
        }
    }
    public static  void sub (int a, int b) {
        int s = a - b;
        if (arabicNumber) {
            System.out.println("Ответ: " + s);}
        else {
            System.out.println("Ответ: " + ArabicToRoman.aRT(s));
        }
    }

    public static  void mul (int a, int b) {
        int s = a * b;
        if (arabicNumber) {
            System.out.println("Ответ: " + s);}
        else {
            System.out.println("Ответ: " + ArabicToRoman.aRT(s));
        }
    }
    public static  void div (int a, int b) {
        try{
            int s = a / b;
            if (arabicNumber) {
                System.out.println("Ответ: " + s);}
            else {
                System.out.println("Ответ: " + ArabicToRoman.aRT(s));
            }
        }
        catch (ArithmeticException e) {
            System.out.print("Деление на 0! ");
        }
    }

    private static String[] pars(String equation) {
        String[] result = equation.split(" ");
        if (result.length != 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите выражение, разделяя каждый символ пробелом");
            equation = scan.nextLine();
            return pars(equation);
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String equation = scan.nextLine();
        String[] result = Calc.pars(equation);
        String part1 = result[0];
        String operation = result[1];
        String part3 = result[2];
        int num1;
        int num2;

        try{
            num1 = Integer.parseInt(part1);
            num2 = Integer.parseInt(part3);}
        catch (NumberFormatException e) {
            arabicNumber = false;

            num1 = RomanToArabic.rTA(result[0]);
            num2 = RomanToArabic.rTA(result[2]);
        }

        if ((num1< 0 || num1>10) || (num2< 0 || num2>10)) throw new Exception("На ввод принимаются только числа от 1 до 10");

        if (arabicNumber){
        }
        else
        {if ((RomanToArabic.rTA(result[0]) <=0) || (RomanToArabic.rTA(result[2]) <=0)) throw new Exception("На ввод принимаются только числа от 1 до 10");}


        if (operation.equals("+")) {
            Calc.sum(num1,num2);
        }
        else if (operation.equals("-")) {
            Calc.sub(num1,num2);
        }
        else if (operation.equals("*")) {
            Calc.mul(num1,num2);
        }
        else if (operation.equals("/")) {
            Calc.div(num1,num2);


        }
    }

}
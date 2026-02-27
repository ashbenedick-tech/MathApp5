package com.example.MathApp5;

public class MathApp5 {

    public static int max(int number1, int number2) {
        return (number1 > number2) ? number1 : number2;
    }

    public static double average(int number1, int number2) {
        return (number1 + number2) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(max(5, 15));
        System.out.println(average(5, 15));
        System.out.println(max(37, -11));
        System.out.println(average(37, -11));
    }

}

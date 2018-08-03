package ru.minaevd.java;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемое количество чисел в ряду Фибоначчи");
        int str = scanner.nextInt();
        if (str < 0) { System.out.println("Введено отрицательное количество. Перезапустите программу и введите корректное значение"); return; }
        long[] result = getFibonacciLine(str);
        for (int i=0; i<str; i++) {
            System.out.print(Long.toString(result[i]) + ", ");
        }
        System.out.println("...");
    }

    /*
    Метод позволяет получить массив чисел ряда Фибоначчи до заданного n-го по порядку числа
     */
    private static long[] getFibonacciLine(int numberOfDigits) {
        long[] fibonacciLine = new long[numberOfDigits]; // объявление и выделение памяти под массив чисел ряда Фибоначчи
        //задаются значения для первых двух чисел ряда
        fibonacciLine[0] = 0;
        fibonacciLine[1] = 1;
        //определяются остальные числа вплоть до введенного n-го числа
        for (int i=2 ;i<numberOfDigits; i++) {
            fibonacciLine[i] = fibonacciLine[i-2] + fibonacciLine[i-1];
        }
        return fibonacciLine;
    }
}

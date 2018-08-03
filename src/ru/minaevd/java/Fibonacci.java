package ru.minaevd.java;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемое количество чисел в ряду Фибоначчи");
        int str = scanner.nextInt();
        if (str < 0) { System.out.println("Введено отрицательное количество. Перезапустите программу и введите корректное значение"); return; }
        long[] result = getFibonacciLineNumber(str);
        for (int i=0; i<str; i++) {
            System.out.print(Long.toString(result[i]) + ", ");
        }
        System.out.println("...");

        System.out.println("Введите максимально возможное значение для числа в ряду Фибоначчи");
        int str1 = scanner.nextInt();
        if (str1 < 0) { System.out.println("Введено отрицательное число. Перезапустите программу и введите корректное значение"); return; }
        long[] result1 = getFibonacciLineValue(str1);
        String s = "";
        for (int i=0; result1[i] <= str1; i++) {
            s = Long.toString(result1[i]) + ", ";
            System.out.print(s);
        }
        System.out.println("...");
    }

    /*
    Метод позволяет получить массив чисел ряда Фибоначчи до заданного n-го по порядку числа
     */
    private static long[] getFibonacciLineNumber(int numberOfDigits) {
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

    /*
    Метод позволяет получить массив чисел ряда Фибоначчи до заданного максимально возможного значения числа
     */
    private static long[] getFibonacciLineValue(int valueOfDigits) {
        long[] fibonacciLine = new long[2];
        fibonacciLine[0] = 0;
        fibonacciLine[1] = 1;
        long temp = 0L; //временная переменная
        long[] tempFibonacciLine = fibonacciLine; // копирование значений результирующего массива во временный
        for(int i = 2; valueOfDigits >= temp; i++) {
            fibonacciLine = new long[i+1]; // увеличивается размер результирующего массива
            temp = tempFibonacciLine[i - 2] + tempFibonacciLine[i - 1]; // временная переменная хранит крайний на данный момент член ряда
            // установка в результирующий массив (на данный момент все значения равны 0) всех известных на данный момент значений членов ряда Фибоначчи
            int k = 1;
            while ((i - k) > 0) {
                fibonacciLine[i] = temp;
                fibonacciLine[i-k] = tempFibonacciLine[i-k];
                ++k;
            }
            tempFibonacciLine = fibonacciLine; //копирование значений членов ряда из результирующего во временный массив
        }
        return fibonacciLine;
    }
}

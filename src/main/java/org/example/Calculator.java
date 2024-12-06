package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Тут даны примеры для проверки того, что нужно согласно ТЗ
        String example1 = "1 + 20";
        String example2 = "1 / 2";
        String example3 = "1";
        String example4 = "1 * 2 1";
        String example5 = "ыыы";
        String example6 = "1 + a";
        String example7 = "1 + 2.1";

        try {
            System.out.println(calc(example1)); // меняйте на любой example
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = validateInput(input);

        // Преобразуем в целые числа и символ
        int a = parseInteger(parts[0]);
        int b = parseInteger(parts[2]);
        String symbol = parts[1];

        // Проверка, что числа находятся в пределах от 1 до 10
        validateDiapason(a, b);

        // Арифметическая операция
        int result = arithmeticOperation(a,b,symbol);

        // Наконец-то возвращаем результат
        return String.valueOf(result);
    }

    private static String[] validateInput(String input) throws Exception {
        // Убираем лишние пробелы и разделяем строку по пробелам
        String[] parts = input.trim().split(" ");

        // У нас должно быть 3 части (два числа и знак операции над ними)
        if (parts.length != 3) {
            throw new Exception("Введена не арифметическая операция");
        }
        return parts;
    }

    private static int parseInteger(String value) throws Exception {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new Exception("Введено не число");
        }
    }

    private static void validateDiapason(int a, int b) throws Exception {
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть в диапазоне 1-10");
        }
    }

    private static int arithmeticOperation(int a, int b, String symbol) throws IllegalStateException {
        switch (symbol) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalStateException("Невалидная операция");
        }
    }
}
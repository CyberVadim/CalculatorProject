package org.example;

public class Calculator {
    public static void main(String[] args) {

        // Тут даны примеры для проверки того, что нужно согласно ТЗ
        String example1 = "1 + 2";
        String example2 = "1 / 2";
        String example3 = "1";
        String example4 = "1 * 2 1";
        String example5 = "ыыы";
        String example6 = " ";
        String example7 = "1 + 2.1";

        try {
            System.out.println(calc(example7)); // меняйте на любой example
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = validateInput(input);

        // Преобразуем в целые числа
        int a = parseInteger(parts[0]);
        int b = parseInteger(parts[2]);

        // Проверка, что числа находятся в пределах от 1 до 10
        validateDiapason(a, b);

        // Проверяем валидность символа арифметической операции
        String symbol = parts[1];
        validateOperationSymbol(symbol);

        // Арифметическая операция
        int result = arithmeticOperation(a,b,symbol);

        // Наконец-то возвращаем результат
        return String.valueOf(result);
    }

    private static String[] validateInput(String input) throws Exception {
        //Проверяем, что input не пустой, не NULL и не имеет букв
        if (input == null || input.isEmpty() || !input.matches(".*[a-zA-Z\\\\u0400-\\\\u04FF].*")) {
            throw new Exception("Невалидный ввод символа");
        }

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

    private static void validateOperationSymbol(String symbol) throws Exception {
        if (!symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")) {
            throw new Exception("Введен некорректный символ арифметической операции");
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
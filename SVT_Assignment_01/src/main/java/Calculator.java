public class Calculator {
    public static int generate(int i, int i1) {
        int min = 0;
        int max = 0;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}

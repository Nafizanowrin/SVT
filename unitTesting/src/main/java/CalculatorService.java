public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int performAddition(int a, int b) {
        return calculator.add(a, b);
    }
}

// Mockito Testing
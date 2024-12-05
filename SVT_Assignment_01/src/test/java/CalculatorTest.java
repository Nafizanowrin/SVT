import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void init() {
        System.out.println("Setup before all tests");
        calculator = new Calculator();
    }

    @BeforeEach
    void setup() {
        System.out.println("Setup before each test");
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup after each test");
    }

    @AfterAll
    static void teardown() {
        System.out.println("Cleanup after all tests");
    }


//                          ** Question 1 **

    @Test
    @DisplayName("Check If Addition Method Works")
    void add() {
        assertEquals(7, calculator.add(4, 3));
    }

    @Test
    @DisplayName("Check If Divide Method Works")
    void divide() {
        assertEquals(7, calculator.divide(49, 7));
    }

    @Test
    void divByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }


//                                 ** Question 2 **

    @Test
    void addEq() {
        assertEquals(39, calculator.add(16, 23));
        assertNotEquals(40, calculator.add(16, 23));
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "3, 1, 2", "7, 4, 3"})
    void addParams(int exp, int a, int b) {
        assertEquals(exp, calculator.add(a, b));
    }

    @Test
    void divEq() {
        assertEquals(16, calculator.divide(16, 1));
        assertNotEquals(23, calculator.divide(16, 23));
    }

    @Test
    void CheckNull() {
        Calculator calc = null;
        assertNull(calc);

        calc = new Calculator();
        assertNotNull(calc);
    }

    @Test
    void CheckCondition() {
        int sum = calculator.add(23, 0);
        assertTrue(sum > 16);
        assertFalse(sum < 16);
    }

    @Test
    void CheckTimeout() {
        assertTimeout(Duration.ofMillis(10), () -> {
            int result = calculator.add(10, 6);
            System.out.println(result);
        });
    }


//                                ** Question 3 **

    @Test
    void DivideExceptionHandling() {
        // Verify that divide by zero throws ArithmeticException
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(16, 0));

        // Verify that divide with valid inputs does not throw any exception
        assertDoesNotThrow(() -> calculator.divide(16, 23));
    }


//                              ** Question 4 **

    @Test
    void ArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void SameInstance() {
        Calculator calc1 = calculator;
        Calculator calc2 = calculator;
        assertSame(calc1, calc2);
    }

    @Test
    void testLinesMatch() {
        List<String> expected = List.of("Nowrin", "Lavendor", "Lover");
        List<String> actual = List.of("Nowrin", "Lavendor", "Lover");

        assertLinesMatch(expected, actual, "Lines do not match");
    }

//                          ** Question 5 **

    @Test
    void ExecutionTimeLimit() {
        // Ensures the add method completes within 10 milliseconds
        assertTimeout(Duration.ofMillis(10), () -> {
            int result = calculator.add(5, 5);
            System.out.println(result);
        });
    }

    //Question 6

    @ParameterizedTest
    @CsvSource({
            "5, 2, 3",   //expected=5, a=2, b=3
            "7, 3, 4",   //expected=7, a=3, b=4
            "0, -1, 1",  // expected=0, a=-1, b=1
            "15, 10, 5"  //expected=15, a=10, b=5
    })
    void CsvSource(int expected, int a, int b) {
        assertEquals(expected, calculator.add(a,b));
    }

//                        ** Question 7 **

    @RepeatedTest(value = 5)
    void generate() {
        int result = Calculator.generate(1, 10);
        System.out.println(result);
        assertTrue(result <= 10);
    }

//                        ** Question 8 **


}

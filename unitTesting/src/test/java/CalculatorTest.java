import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUPBeforeAll() {
        // Runs once before all test cases. Setup tasks shared across tests can go here.
    }

    @AfterAll
    static void setUPAfterAll() {
        // Runs once after all test cases. Cleanup tasks can go here.
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Runs before each test. Initializes the `calculator` object.
    }

    @AfterEach
    void tearDown() {
        // Runs after each test. Cleanup specific to each test can go here.
    }

    @Test
    void add() {
        // Check if the result of addition is correct.
        assertEquals(3, calculator.add(1, 2)); // Asserts that 1 + 2 equals 3.
        assertNotEquals(4, calculator.add(1, 2)); // Asserts that 1 + 2 does not equal 4.
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "3, 1, 2"})
    void add(int exp, int a, int b) {
        // Runs the addition test with multiple inputs from the CSV source.
        assertEquals(exp, calculator.add(a, b)); // Asserts the result matches the expected value.
    }

    @Test
    void checkCondition() {
        // Verify boolean conditions.
        assertTrue(calculator.checkCondition(6, 5)); // Asserts the condition is true.
        assertFalse(calculator.checkCondition(5, 6)); // Asserts the condition is false.
    }

    @Test
    void getException() {
        // Check exception handling.
        assertThrows(Exception.class, () -> calculator.getException()); // Asserts that an exception is thrown.
        assertDoesNotThrow(() -> calculator.add(2, 3)); // Asserts that no exception is thrown for this operation.

        assertTimeout(Duration.ofMillis(2), () -> {
            // Asserts the operation completes within the specified timeout.
            calculator.add(3, 5);
        });
    }

    @Test
    void getArray() {
        // Check array and list matching.
        List<String> str1 = Arrays.asList("a", "b", "c");
        List<String> str2 = Arrays.asList("a", "b", "c");

        assertLinesMatch(str1, str2); // Asserts two lists of strings match line by line.
        assertArrayEquals(new int[]{1, 2, 3}, calculator.getArray()); // Asserts arrays are equal.
    }

    @Test
    void checkBool() {
        // Check object references and nullability.
        Calculator calculator1 = calculator;
        Calculator calculator2 = new Calculator();

        assertSame(calculator, calculator1); // Asserts two objects are the same (reference equality).
        assertNotSame(calculator1, calculator2); // Asserts two objects are not the same.

        Calculator calculator3 = null;
        assertNull(calculator3); // Asserts the object is null.
        assertNotNull(calculator); // Asserts the object is not null.
    }

    // Example of repeated test (commented out for now).
//    @RepeatedTest(value = 3)
//    void checkRandom() {
//        // Check some random functionality. Asserts would compare the expected result.
//        assertEquals(1.5, Math.random());
//    }

    // Method source provider for parameterized test.
    List<String> getList() {
        return Arrays.asList("a", "b", "c");
    }

    @ParameterizedTest
    // Example of parameterized test with various sources (commented out).
//    @ValueSource(strings = {"1", "2", "3"})
//    @CsvFileSource(resources = "/vals.csv")
    @MethodSource("getList")
    void getString(String str) {
        // Check string matching from parameterized input.
        assertEquals(str, calculator.getString(str)); // Asserts the result equals the input string.
    }
}

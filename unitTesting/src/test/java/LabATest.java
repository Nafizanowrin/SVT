import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LabATest {

    private LabA labA;

    @Test
    void reverse() {

        assertNull(LabA.reverse(null));

        String s = LabA.reverse("svt lab test");
        assertNotNull(s);

        assertEquals("olleh", LabA.reverse("hello"));
    }

    @Test
    void sortArray() {
        int[] a1 = new int[]{5, 3, 1};
        int[] a2 = new int[]{1, 3, 5};

//        List<String> l1 = Arrays.asList("5, 3, 1");
//        List<String> l2 = Arrays.asList("1, 3, 5");
//
//        assertLinesMatch(l1, l2);
        assertArrayEquals(a2, labA.sortArray(a1));

    }

    @Test
    void divide() {
        assertThrows(Exception.class, () -> {
            labA.divide(2, 0);
        });

        assertEquals(2, LabA.divide(5, 2));
    }

    @RepeatedTest(value = 5)
    void generate() {
        int result = labA.generate(1, 10);
//        System.out.println(result);
        assertTrue(result <= 10);
    }

    List<Integer> getList() {
        return Arrays.asList(-5, -1, 5);
    }

    @ParameterizedTest
    @CsvSource({"6, 3, 2", "-5, -1, 5", "0, 7, 0"})
    void multiply(int exp, int a, int b) {
        assertEquals(exp, labA.multiply(a, b));
    }

    List<String> getString(){
        return Arrays.asList("a", "b", "c");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @MethodSource("getString")
    void getString(String str) {
        assertEquals(str, labA.getString(str));
    }


}
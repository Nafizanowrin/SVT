import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void performAddition() {
        when(calculator.add(3, 2)).thenReturn(5);
        assertEquals(5, calculatorService.performAddition(3, 2));

        verify(calculator).add(3, 2);
    }
}
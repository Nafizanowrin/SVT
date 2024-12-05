package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


//                         ** Question 2 **

class TemperatureConverterTest {

    @ParameterizedTest
    @CsvSource({
            "32, 0",         // Celsius: 0, Fahrenheit: 32
            "77, 25",        // Celsius: 25, Fahrenheit: 77
            "-40, -40"       // Celsius: -40, Fahrenheit: -40
    })
    void testCelsiusToFahrenheit(double expectedFahrenheit, double celsius) {

        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius),
                0.01); // Delta for floating-point comparison
    }

    @Test
    @DisplayName("Check If  Exception Works")
    void CelsiusToFahrenheit() {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(-274) );
    }
}

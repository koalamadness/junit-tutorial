package net.javaguides.annotations;

import net.javaguides.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void factorialTest() {

        Factorial factorial = new Factorial();

        int result = factorial.factorial(5);

        assertEquals(120, result);
    }
}
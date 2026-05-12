package net.javaguides;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void antesTodo() {
        System.out.println("🚀 Iniciando suite de pruebas de Calculator...");
    }

    @BeforeEach
    void setup() {
        System.out.println("🔧 Creando nueva instancia de Calculator...");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("🧹 Limpiando después del test...");
        calculator = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("✅ Suite de pruebas finalizada.");
    }

    @Test
    @DisplayName("✅ Suma de dos números positivos")
    public void addTest() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 20);

        assertEquals(30, result);
    }

    @Test
    @Disabled("🚧 To implement - ticket #101")
    @DisplayName("❌ División lanza excepción si divisor es cero")
    void divideTestPorCero() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @ParameterizedTest(name = "✅ {0} + 1 debería ser {0} + 1")
    @ValueSource(ints = {1, 5, 10, 100, -5, 0})
    @DisplayName("Sumar cualquier número con 0 retorna el mismo número")
    void addUno(int num) {
        int result = calculator.add(num, 1);
        assertEquals(num + 1, result);
    }

    @ParameterizedTest(name = "✅ {0} + {1} = {2}")
    @CsvSource({
            "10,  20,  30",
            "5,    5,  10",
            "0,    0,   0",
            "-5,  10,   5",
            "-5,  -5, -10",
            "100, 200, 300"
    }
    )
    @DisplayName("Suma con múltiples casos")
    void addTest(int a, int b, int esperado) {
        int result = calculator.add(a, b);
        assertEquals(esperado, result);
    }

    @ParameterizedTest(name = "✅ {0} + {1} = {2}")
    @MethodSource("addData")
    @DisplayName("Addition using MethodSource")
    void addTestMethodSource(int a , int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    static Stream<Arguments> addData() {
        return Stream.of(
                Arguments.of(1,    1,   2),
                Arguments.of(10,  20,  30)
        );
    }



}
package net.javaguides;

import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorIntegrationTest {

    private CalculatorRepository repository;
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        // Creamos los objetos REALES y los conectamos
        repository = new CalculatorRepository();  // real ✅
        service    = new CalculatorService(repository); // real ✅
    }

    @Test
    @DisplayName("Sumar debería guardar la operación en el historial")
    void sumarDeberiaGuardarEnHistorial() {
        // Act — llamamos al servicio
        int resultado = service.add(10, 20);

        // Assert 1 — el cálculo está bien
        assertEquals(30, resultado);

        // Assert 2 — SE GUARDÓ en el repositorio (integración!)
        assertEquals(1, repository.totalOperaciones());
        assertEquals("10 + 20 = 30", repository.obtenerHistorial().getFirst());
    }

    @Test
    @DisplayName("Varias operaciones deberían acumularse en el historial")
    void variasOperacionesDeberianAcumularseEnHistorial() {
        // Act — hacemos 3 operaciones
        service.add(1, 1);
        service.add(5, 5);
        service.divide(10, 2);

        // Assert — las 3 se guardaron
        assertEquals(3, repository.totalOperaciones());

        List<String> historial = repository.obtenerHistorial();
        assertEquals("1 + 1 = 2",   historial.get(0));
        assertEquals("5 + 5 = 10",  historial.get(1));
        assertEquals("10 / 2 = 5",  historial.get(2));
    }

    @Test
    @DisplayName("División por cero NO debería guardarse en el historial")
    void divisionPorCeroNoDeberiaGuardarseEnHistorial() {
        // Act & Assert — lanza excepción
        assertThrows(ArithmeticException.class,
                () -> service.divide(10, 0)
        );

        // El historial debe estar vacío — no se guardó nada
        assertEquals(0, repository.totalOperaciones());
    }

    @Test
    @DisplayName("Remover last Operation reduce el espacio")
    void removerOperacion() {

        List<String> historial = repository.obtenerHistorial();

        service.add(1, 1);
        service.add(5, 5);
        service.divide(10, 2);

        int beforeRemoveSize = repository.totalOperaciones();

        service.removeLastOperation();

        int afterRemoveSize = repository.totalOperaciones();

        assertEquals(beforeRemoveSize - 1, afterRemoveSize);

    }
}
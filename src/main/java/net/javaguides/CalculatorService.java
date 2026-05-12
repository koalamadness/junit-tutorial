package net.javaguides;

public class CalculatorService {
    private final CalculatorRepository repository;

    // El servicio DEPENDE del repositorio
    public CalculatorService(CalculatorRepository repository) {
        this.repository = repository;
    }

    public int add(int a, int b) {
        int resultado = a + b;

        // guarda en el historial — aquí es donde se INTEGRAN las 2 clases
        repository.guardar(a + " + " + b + " = " + resultado);

        return resultado;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir por cero");

        int resultado = a / b;
        repository.guardar(a + " / " + b + " = " + resultado);

        return resultado;
    }

    public void removeLastOperation() {
        repository.removeLastOperation();
    }
}
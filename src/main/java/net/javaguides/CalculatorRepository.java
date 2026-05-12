package net.javaguides;

import java.util.ArrayList;
import java.util.List;

// Clase 1 — Repositorio (guarda y busca datos)
public class CalculatorRepository {
    private final List<String> historial = new ArrayList<>();

    public void guardar(String operacion) {
        historial.add(operacion);
    }

    public List<String> obtenerHistorial() {
        return historial;
    }

    public int totalOperaciones() {
        return historial.size();
    }

    public void removeLastOperation() {
        historial.removeLast();
    }
}
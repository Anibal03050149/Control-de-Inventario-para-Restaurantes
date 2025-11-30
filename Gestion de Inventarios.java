import java.util.*;
import java.time.LocalDateTime;

// CLASE INSUMO
class Insumo {
    String nombre;
    int cantidad;
    int stockMinimo;
    LocalDateTime fechaCaducidad;

    public Insumo(String nombre, int cantidad, int stockMinimo, LocalDateTime fechaCaducidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
        this.fechaCaducidad = fechaCaducidad;
    }
}
// CLASE PLATILLO
class Platillo {
    String nombre;
    Map<String, Integer> insumosRequeridos; // insumo -> cantidad necesaria

    public Platillo(String nombre, Map<String, Integer> insumosRequeridos) {
        this.nombre = nombre;
        this.insumosRequeridos = insumosRequeridos;
    }


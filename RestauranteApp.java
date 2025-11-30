import java.util.*;
import java.time.LocalDateTime;


// Clase Insumo

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


// Clase Platillo

class Platillo {
    String nombre;
    Map<String, Integer> insumosRequeridos; // insumo -> cantidad necesaria

    public Platillo(String nombre, Map<String, Integer> insumosRequeridos) {
        this.nombre = nombre;
        this.insumosRequeridos = insumosRequeridos;
    }
}


// Módulo Inventario

class Inventario {
    Map<String, Insumo> insumos = new HashMap<>();

    public void registrarEntrada(String nombre, int cantidad, int stockMinimo, LocalDateTime caducidad) {
        if (insumos.containsKey(nombre)) {
            insumos.get(nombre).cantidad += cantidad;
        } else {
            insumos.put(nombre, new Insumo(nombre, cantidad, stockMinimo, caducidad));
        }
        System.out.println("Entrada registrada: " + nombre + " - Cantidad: " + cantidad);
    }

    public boolean registrarSalida(String nombre, int cantidad) {
        if (!insumos.containsKey(nombre)) {
            System.out.println("Insumo no encontrado: " + nombre);
            return false;
        }
        Insumo ins = insumos.get(nombre);
        if (ins.cantidad < cantidad) {
            System.out.println("Stock insuficiente para: " + nombre);
            return false;
        }
        ins.cantidad -= cantidad;
        if (ins.cantidad <= ins.stockMinimo) {
            System.out.println("ALERTA: Stock bajo para " + nombre);
        }
        if (ins.fechaCaducidad.isBefore(LocalDateTime.now().plusDays(2))) {
            System.out.println("ALERTA: Insumo próximo a caducar: " + nombre);
        }
        return true;
    }

    public void mostrarStock() {
        System.out.println("=== Inventario ===");
        for (Insumo ins : insumos.values()) {
            System.out.println(ins.nombre + ": " + ins.cantidad);
        }
    }
}


// Módulo Ventas

class Pedido {
    int mesa;
    List<Platillo> platillos;
    LocalDateTime fechaHora;
    String usuario;

    public Pedido(int mesa, List<Platillo> platillos, String usuario) {
        this.mesa = mesa;
        this.platillos = platillos;
        this.fechaHora = LocalDateTime.now();
        this.usuario = usuario;
    }
}

class Ventas {
    Inventario inventario;
    List<Pedido> historial = new ArrayList<>();

    public Ventas(Inventario inventario) {
        this.inventario = inventario;
    }

    public void registrarPedido(Pedido pedido) {
        // Descontar insumos automáticamente
        boolean disponible = true;
        for (Platillo p : pedido.platillos) {
            for (Map.Entry<String, Integer> entry : p.insumosRequeridos.entrySet()) {
                if (!inventario.registrarSalida(entry.getKey(), entry.getValue())) {
                    disponible = false;
                }
            }
        }

        if (disponible) {
            historial.add(pedido);
            System.out.println("Pedido registrado correctamente en la mesa " + pedido.mesa);
        } else {
            System.out.println("Pedido no se pudo completar por falta de insumos.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("=== Historial de Ventas ===");
        for (Pedido p : historial) {
            System.out.println("Mesa: " + p.mesa + " - Usuario: " + p.usuario + " - Fecha: " + p.fechaHora);
            System.out.println("Platillos:");
            for (Platillo platillo : p.platillos) {
                System.out.println(" - " + platillo.nombre);
            }
        }
    }
}


// Clase Principal

public class RestauranteApp {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Registrar insumos
        inventario.registrarEntrada("Tomate", 50, 10, LocalDateTime.now().plusDays(5));
        inventario.registrarEntrada("Lechuga", 30, 5, LocalDateTime.now().plusDays(3));
        inventario.registrarEntrada("Carne", 20, 5, LocalDateTime.now().plusDays(2));

        // Crear platillos
        Map<String, Integer> ensaladaInsumos = new HashMap<>();
        ensaladaInsumos.put("Tomate", 2);
        ensaladaInsumos.put("Lechuga", 1);
        Platillo ensalada = new Platillo("Ensalada", ensaladaInsumos);

        Map<String, Integer> hamburguesaInsumos = new HashMap<>();
        hamburguesaInsumos.put("Carne", 1);
        hamburguesaInsumos.put("Lechuga", 1);
        hamburguesaInsumos.put("Tomate", 1);
        Platillo hamburguesa = new Platillo("Hamburguesa", hamburguesaInsumos);

        // Módulo de ventas
        Ventas ventas = new Ventas(inventario);

        // Registrar pedido
        List<Platillo> pedido1Platillos = Arrays.asList(ensalada, hamburguesa);
        Pedido pedido1 = new Pedido(1, pedido1Platillos, "Camarero1");
        ventas.registrarPedido(pedido1);

        // Mostrar historial y stock
        ventas.mostrarHistorial();
        inventario.mostrarStock();
    }
}

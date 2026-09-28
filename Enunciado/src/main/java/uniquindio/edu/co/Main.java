package uniquindio.edu.co;
import uniquindio.edu.co.model.*;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {


    static void mostrarProductos(String titulo, ArrayList<Producto> lista) {
        System.out.println(titulo);
        if (lista.isEmpty()) {
            System.out.println("  (ninguno)");
        }
        Iterator<Producto> it = lista.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println("  - " + p.getNombre() + " ($" + p.getPrecio() + ")");
        }
    }


    static void probarInventarioGenerico() {
        System.out.println("\n--- Prueba 1: InventarioCaja<T> con Integer y String ---");

        InventarioCaja<Integer> numeros = new InventarioCaja<>();
        numeros.agregar(5);
        numeros.agregar(12);
        numeros.agregar(8);
        numeros.agregar(20);
        numeros.agregar(12);
        System.out.println("Enteros mayores que 10: " + numeros.filtrarMayoresQue(10));
        System.out.println("Enteros mayores que 12 (el igual no entra): " + numeros.filtrarMayoresQue(12));
        System.out.println("Enteros mayores que 100: " + numeros.filtrarMayoresQue(100));

        InventarioCaja<String> palabras = new InventarioCaja<>();
        palabras.agregar("manzana");
        palabras.agregar("banano");
        palabras.agregar("uva");
        palabras.agregar("pera");
        System.out.println("Palabras mayores que \"mango\": " + palabras.filtrarMayoresQue("mango"));
    }


    static void probarCaja() {
        System.out.println("\n--- Prueba 2: Caja, Cliente y Factura ---");

        Caja caja = new Caja();
        Producto arroz = new Producto("Arroz", 4200);
        Producto leche = new Producto("Leche", 3800);
        Producto aceite = new Producto("Aceite", 15000);
        Producto cafe = new Producto("Café", 12500);
        Producto carne = new Producto("Carne", 28000);

        caja.agregarAlInventario(arroz);
        caja.agregarAlInventario(leche);
        caja.agregarAlInventario(aceite);
        caja.agregarAlInventario(cafe);
        caja.agregarAlInventario(carne);

        mostrarProductos("Productos más caros que $10000:",
                caja.consultarMasCarosQue(new Producto("Referencia", 10000)));
        mostrarProductos("Productos más caros que $12500 (el igual no entra):",
                caja.consultarMasCarosQue(new Producto("Referencia", 12500)));
        mostrarProductos("Productos más caros que $50000:",
                caja.consultarMasCarosQue(new Producto("Referencia", 50000)));

        Cliente cliente = new Cliente("Ana Gómez", "1094000000");
        ArrayList<Producto> compras = new ArrayList<>();
        compras.add(arroz);
        compras.add(leche);
        compras.add(aceite);
        Factura factura = caja.facturar(cliente, compras);
        System.out.println("Factura de " + cliente.getNombre() + " -> total: $" + factura.calcularTotal());
    }

    static void probarNulos() {
        System.out.println("\n--- Prueba 3: valores nulos ---");
        InventarioCaja<Integer> inventario = new InventarioCaja<>();
        try {
            inventario.agregar(null);
        } catch (IllegalArgumentException e) {
            System.out.println("agregar(null) rechazado: " + e.getMessage());
        }
        try {
            inventario.filtrarMayoresQue(null);
        } catch (IllegalArgumentException e) {
            System.out.println("filtrarMayoresQue(null) rechazado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        probarInventarioGenerico();
        probarCaja();
        probarNulos();
    }
}




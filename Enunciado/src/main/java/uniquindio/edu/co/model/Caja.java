package uniquindio.edu.co.model;

import java.util.ArrayList;


public class Caja {
    private final InventarioCaja<Producto> inventario;

    public Caja() {
        this.inventario = new InventarioCaja<>();
    }

    public void agregarAlInventario(Producto producto) {
        inventario.agregar(producto);
    }

    public Factura facturar(Cliente cliente, ArrayList<Producto> compras) {
        return new Factura(cliente, compras);
    }

    /** Usa el método del ejercicio: filtrarMayoresQue del inventario. */
    public ArrayList<Producto> consultarMasCarosQue(Producto umbral) {
        return inventario.filtrarMayoresQue(umbral);
    }
}
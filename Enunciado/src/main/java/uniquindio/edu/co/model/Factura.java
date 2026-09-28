package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.Iterator;


public class Factura {
    private final Cliente cliente;
    private final ArrayList<Producto> productos;

    public Factura(Cliente cliente, ArrayList<Producto> productos) {
        this.cliente = cliente;
        this.productos = new ArrayList<>(productos);
    }

    public double calcularTotal() {
        double total = 0;
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            total += it.next().getPrecio();
        }
        return total;
    }
}
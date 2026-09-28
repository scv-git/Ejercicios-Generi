package uniquindio.edu.co.model;


import java.util.ArrayList;
import java.util.Iterator;


public class InventarioCaja<T extends Comparable<T>> {
    private final ArrayList<T> elementos;

    public InventarioCaja() {
        this.elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }
        elementos.add(elemento);
    }


    public ArrayList<T> filtrarMayoresQue(T umbral) {
        if (umbral == null) {
            throw new IllegalArgumentException("El umbral no puede ser nulo");
        }
        ArrayList<T> resultado = new ArrayList<>();
        Iterator<T> it = elementos.iterator();
        while (it.hasNext()) {
            T actual = it.next(); // un solo next() por vuelta
            if (actual.compareTo(umbral) > 0) {
                resultado.add(actual);
            }
        }
        return resultado;
    }
}
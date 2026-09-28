import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**

 *
 *
 */
public class Main {
    public static void main(String[] args) {
        probarEjercicio1();
        probarEjercicio2();
        probarEjercicio3();
        probarEjercicio4();
        probarEjercicio5();
        probarEjercicio6();
        probarEjercicio7();
        probarEjercicio8();
        probarEjercicio9();
    }


    // =====================================================================
    // EJERCICIO 1: Clase genérica Caja<T> (Se mantiene como clase por ser mutable)
    // =====================================================================
    static class Caja<T> {
        private T contenido;

        public void guardar(T valor) {
            this.contenido = valor;
        }

        public T obtener() {
            return contenido;
        }
    }

    // =====================================================================
    // EJERCICIO 2: Método genérico mostrarElemento
    // =====================================================================
    static <T> void mostrarElemento(T elemento) {
        System.out.println("Elemento: " + elemento);
    }

    // =====================================================================
    // EJERCICIO 3: Interfaz genérica Contenedor<T> + ListaContenedor<T>
    // =====================================================================
    interface Contenedor<T> {
        void agregar(T item);
        T obtener(int indice);
    }

    static class ListaContenedor<T> implements Contenedor<T> {
        private final List<T> items = new ArrayList<>();

        @Override
        public void agregar(T item) {
            items.add(item);
        }

        @Override
        public T obtener(int indice) {
            return items.get(indice);
        }

        public int tamanio() {
            return items.size();
        }
    }

    // =====================================================================
    // EJERCICIO 4: Método genérico intercambiar
    // =====================================================================
    static <T> void intercambiar(T[] arreglo, int i, int j) {
        T temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }

    // =====================================================================
    // EJERCICIO 5: Record Par<T> (Reemplaza la clase tradicional)
    // =====================================================================
    record Par<T>(T primero, T segundo) {
        public boolean sonIguales() {
            return Objects.equals(primero, segundo);
        }
    }

    // =====================================================================
    // EJERCICIO 6: Record CajaNumerica<T extends Number>
    // =====================================================================
    record CajaNumerica<T extends Number>(T numero) {
        public double doble() {
            return numero.doubleValue() * 2;
        }
    }

    // =====================================================================
    // EJERCICIO 7: Método genérico sumar<T extends Number>
    // =====================================================================
    static <T extends Number> double sumar(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // =====================================================================
    // EJERCICIO 8: Record EntidadPersistente<T extends Number & Comparable<T>>
    // =====================================================================
    record EntidadPersistente<T extends Number & Comparable<T>>(T valor) {
        /** Negativo si es menor, 0 si es igual, positivo si es mayor que la otra entidad. */
        public int comparar(EntidadPersistente<T> otra) {
            return this.valor.compareTo(otra.valor);
        }
    }

    // =====================================================================
    // EJERCICIO 9: Método genérico procesar<T extends Runnable & Comparable<T>>
    // =====================================================================

    record Tarea(String nombre, int prioridad) implements Runnable, Comparable<Tarea> {
        @Override
        public void run() {
            System.out.println("  Ejecutando tarea '" + nombre + "' (prioridad " + prioridad + ")");
        }

        @Override
        public int compareTo(Tarea otra) {
            return Integer.compare(this.prioridad, otra.prioridad);
        }
    }

    static <T extends Runnable & Comparable<T>> int procesar(T objeto, T otro) {
        objeto.run();
        return objeto.compareTo(otro);
    }

    // =====================================================================
    // PRUEBAS (Utilizando 'var' para inferencia de tipos local)
    // =====================================================================
    static void probarEjercicio1() {
        System.out.println("\n--- Ejercicio 1: Caja<T> ---");
        var cajaTexto = new Caja<String>();
        cajaTexto.guardar("Hola genéricos");
        System.out.println("Caja<String> contiene: " + cajaTexto.obtener());

        var cajaEntero = new Caja<Integer>();
        cajaEntero.guardar(42);
        System.out.println("Caja<Integer> contiene: " + cajaEntero.obtener());
    }

    static void probarEjercicio2() {
        System.out.println("\n--- Ejercicio 2: mostrarElemento ---");
        mostrarElemento("Java 27");
        mostrarElemento(2027);
        mostrarElemento(3.14);
        mostrarElemento(true);
        mostrarElemento(List.of(1, 2, 3)); // Reemplazo moderno de Arrays.asList
    }

    static void probarEjercicio3() {
        System.out.println("\n--- Ejercicio 3: Contenedor<T> / ListaContenedor<T> ---");
        var nombres = new ListaContenedor<String>();
        nombres.agregar("Ana");
        nombres.agregar("Luis");
        nombres.agregar("Marta");
        System.out.println("Índice 0: " + nombres.obtener(0));
        System.out.println("Índice 2: " + nombres.obtener(2));

        var numeros = new ListaContenedor<Integer>();
        numeros.agregar(10);
        numeros.agregar(20);
        System.out.println("ListaContenedor<Integer> tamaño: " + numeros.tamanio()
                + ", índice 1: " + numeros.obtener(1));
    }

    static void probarEjercicio4() {
        System.out.println("\n--- Ejercicio 4: intercambiar ---");
        var numeros = new Integer[]{1, 2, 3, 4, 5};
        System.out.println("Antes:   " + Arrays.toString(numeros));
        intercambiar(numeros, 0, 4);
        System.out.println("Después: " + Arrays.toString(numeros));

        var palabras = new String[]{"uno", "dos", "tres"};
        System.out.println("Antes:   " + Arrays.toString(palabras));
        intercambiar(palabras, 0, 2);
        System.out.println("Después: " + Arrays.toString(palabras));
    }

    static void probarEjercicio5() {
        System.out.println("\n--- Ejercicio 5: Par<T> ---");
        var p1 = new Par<>("java", "java");
        var p2 = new Par<>("java", "kotlin");
        var p3 = new Par<>(7, 7);
        System.out.println(p1 + " ¿iguales? " + p1.sonIguales());
        System.out.println(p2 + " ¿iguales? " + p2.sonIguales());
        System.out.println(p3 + " ¿iguales? " + p3.sonIguales());
    }

    static void probarEjercicio6() {
        System.out.println("\n--- Ejercicio 6: CajaNumerica<T extends Number> ---");
        var cajaInt = new CajaNumerica<>(21);
        var cajaDouble = new CajaNumerica<>(2.5);
        // Los Records generan métodos de acceso con el mismo nombre del atributo, sin "get"
        System.out.println("Doble de " + cajaInt.numero() + " = " + cajaInt.doble());
        System.out.println("Doble de " + cajaDouble.numero() + " = " + cajaDouble.doble());
    }

    static void probarEjercicio7() {
        System.out.println("\n--- Ejercicio 7: sumar<T extends Number> ---");
        System.out.println("sumar(3, 4)        = " + sumar(3, 4));
        System.out.println("sumar(2.5, 1.25)   = " + sumar(2.5, 1.25));
        System.out.println("sumar(10L, 5L)     = " + sumar(10L, 5L));
    }

    static void probarEjercicio8() {
        System.out.println("\n--- Ejercicio 8: EntidadPersistente<T extends Number & Comparable<T>> ---");
        var e1 = new EntidadPersistente<>(10);
        var e2 = new EntidadPersistente<>(25);
        System.out.println(e1 + " comparado con " + e2 + " -> " + e1.comparar(e2));
        System.out.println(e2 + " comparado con " + e1 + " -> " + e2.comparar(e1));
        System.out.println(e1 + " comparado con " + e1 + " -> " + e1.comparar(e1));
    }

    static void probarEjercicio9() {
        System.out.println("\n--- Ejercicio 9: procesar<T extends Runnable & Comparable<T>> ---");
        var baja = new Tarea("Enviar reporte", 1);
        var alta = new Tarea("Corregir bug crítico", 5);

        int resultado = procesar(baja, alta);
        System.out.println("Resultado de comparar (baja vs alta): " + resultado);

        resultado = procesar(alta, baja);
        System.out.println("Resultado de comparar (alta vs baja): " + resultado);
    }


}
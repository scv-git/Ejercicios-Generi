package uniquindio.edu.co.model;


public class Cliente {
    private final String nombre;
    private final String documento;

    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }
}
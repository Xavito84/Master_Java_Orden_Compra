public class Producto {

    // Atributos privados
    private String fabricante;
    private String nombre;
    private int precio;

    // Constructor para inicializar los valores
    public Producto(String fabricante, String nombre, int precio) {
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos getter
    public String getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

}

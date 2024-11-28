import java.util.Arrays;
import java.util.Date;

public class OrdenCompra {

    // Campos privados
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos = new Producto[4]; // Arreglo fijo de 4 productos
    private static int ultimoID = 1; // Para el autoincremento del ID
    private int contadorProductos = 0; // Para llevar la cuenta de productos añadidos

    // Constructor que inicializa solo la descripción
    public OrdenCompra(String descripcion) {
        this.id = ultimoID++; // Incrementa automáticamente el ID
        this.descripcion = descripcion;
    }

    // Métodos getter
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProducto() {
        return productos;
    }

    // Métodos setter para cliente y fecha
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para agregar productos al arreglo
    public void addProducto(Producto producto) {
        if (contadorProductos < this.productos.length) { // Verifica si hay espacio
            this.productos[contadorProductos++] = producto;
        } else {
            throw new ArrayIndexOutOfBoundsException("No se pueden agregar más de 4 productos.");
        }

    }

    // Método que devuelve el gran total
    public double getGranTotal() {
        double total = 0;
        for (Producto producto : productos) {
            if (producto != null) { // Ignorar posiciones nulas
                total += producto.getPrecio();
            }
        }
        return total;
    }

    // Sobrescribir el método toString() para imprimir la orden
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Orden ID: ").append(id).append("\n")
                .append("Descripción: ").append(descripcion).append("\n")
                .append("Fecha: ").append(fecha).append("\n")
                .append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n")
                .append("Productos:\n");

        for (Producto producto : productos) {
            if (producto != null) { // Validar que no sea nulo
                sb.append("  - Fabricante: ").append(producto.getFabricante())
                        .append(", Nombre: ").append(producto.getNombre())
                        .append(", Precio: ").append(producto.getPrecio()).append("€\n");
            }
        }

        sb.append("Gran Total: ").append(getGranTotal()).append("€\n")
                .append("-------------------------------------------------\n");

        return sb.toString();
    }
}




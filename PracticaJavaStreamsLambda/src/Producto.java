public class Producto {
    private String nombre;
    private String Categoria;
    private Double precio;

    public Producto(String nombre, String Categoria, Double precio) {
        this.nombre = nombre;
        this.Categoria = Categoria;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return Categoria;
    }
    public Double getPrecio(){
        return precio;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Categoria: " + Categoria + ", Precio: " + precio;
    }
}

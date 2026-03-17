import java.util.ArrayList;
public class tienda {
    private String nombre;
    private ArrayList<producto> productos;
    
     
    public tienda(String nombre){
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        
    }

    public void agregarProducto(producto p){
        productos.add(p);
    }

    public double calcularInventario(){
        double total = 0;

        for(producto p : productos){
            total += p.getPrecio();
        }
        
        return total;
    }
}

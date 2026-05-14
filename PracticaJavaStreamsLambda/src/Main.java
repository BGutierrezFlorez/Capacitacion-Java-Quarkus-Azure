import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Laptop", "Tecnologia", 3500.00));
        productos.add(new Producto("Mouse", "Tecnologia",80.0 ));
        productos.add(new Producto("Teclado", "Tecnologia", 150.0));
        productos.add(new Producto("Silla", "Hogar", 500.00));
        productos.add(new Producto("Mesa", "Hogar", 800.00));

        // Filtrar productos mayores a 300
        System.out.println("PRODUCTOS MAYORES A 300");

        productos.stream()
                .filter(producto -> producto.getPrecio() > 300)
                .forEach(System.out::println);

        // Buscar productos por tecnologia
        System.out.println("\nPRODUCTOS DE TECNOLOGIA");

        productos.stream()
                .filter(producto -> producto.getCategoria().equals("Tecnologia"))
                .forEach(System.out::println);

        // Calcular el promedio de precios
        OptionalDouble promedio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average();

        System.out.println("\nPROMEDIO DE PRECIOS");

        if(promedio.isPresent()) {
            System.out.println(promedio.getAsDouble());
        }
    }


}

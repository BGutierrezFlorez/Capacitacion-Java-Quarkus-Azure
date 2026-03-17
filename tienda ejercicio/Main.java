public class Main {
    public static void main(String[] args) {
        
        // crear productos
        producto p1 = new producto("Arroz", 3000, 5);
        producto p2 = new producto("Leche", 2500, 3);
        producto p3 = new producto("Huevos", 500, 12);
        
        // crear tienda
        tienda tienda = new tienda("Mi tienda del puebo");

        // agregar productos a la tienda 
        tienda.agregarProducto(p1);
        tienda.agregarProducto(p2);
        tienda.agregarProducto(p3);
        
        // Mostrar inventario total

        double total = tienda.calcularInventario();
        System.out.println("Inventario total de la tienda: $" + total);
    }
}

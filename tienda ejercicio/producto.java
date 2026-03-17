public class producto {
    // atributos de la clase 
        public String nombre;
        public double precio;
        public int cantidad;

        public producto(String nombre, double precio, int cantidad){
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad; 
        }

        public String getNombre(){
            return nombre;
        }

        public double getPrecio(){
            return precio;
        }
        public int getCantidad(){
            return cantidad;
        }
    }

   

import java.util.ArrayList;

public class biblioteca{
    public static void agregarLibros(ArrayList<String> libros, String libro){
        libros.add(libro);
        System.out.println("Libro agregado " + libro);
    }

    public static void buscarLibrosPorTitulo(ArrayList<String> libros, String tituloBuscado){

        boolean encontrado = false;
        for(String libro : libros){
            if(libro.toLowerCase().contains(tituloBuscado.toLowerCase())){
                System.out.println("Libro encontrado: " + libro);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontro ningun libro con ese titulo");
        }

    }

    public static void listarLibrosDisponibles(ArrayList<String> libros){
        System.out.println("\nLibros disponibles");
        for(String libro : libros){
            System.out.println("-" + libro);
        }

    }

    public void main(String[] args) {
        ArrayList<String> libros = new ArrayList<>();
        libros.add("El señor de los anillos la comunidad del anillo");
        libros.add("29 de Julio de 1954");
        libros.add("479 paginas");

        // usamos el metodo para agregar otro libro
        agregarLibros(libros, "Harry Potter y la piedra filosofal");

        // mostrar los libros
        System.out.println("\nLista de libros:");
        for(String libro : libros){
            System.out.println(libro);
        }

        // mostrar los libros
        listarLibrosDisponibles(libros);

        // buscar libro por titulo
        System.out.println("\nBuscando a 'harry'...");
        buscarLibrosPorTitulo(libros, "harry");
    }
}
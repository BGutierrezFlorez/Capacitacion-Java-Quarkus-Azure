import model.Transaccion;
import service.ServicioTransacciones;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Transaccion> lista = List.of(

                new Transaccion(1, "Carlos", 1500000,
                        "Transferencia", LocalDate.now(), true),

                new Transaccion(2, "Brayan", 250000,
                        "Pago", LocalDate.now(), false),

                new Transaccion(3, "Isabel", 5000000,
                        "Compra", LocalDate.now(), true),

                new Transaccion(4, "Carolina", 800000,
                        "Pago", LocalDate.now(), false)
        );

        ServicioTransacciones servicio =
                new ServicioTransacciones(lista);

        System.out.println("=== TRANSACCIONES SOSPECHOSAS ===");

        servicio.ObtenerSospechosas()
                .forEach(System.out::println);

        System.out.println("=== Montos Altos ===");
        
        servicio.ObtenerMontosAltos(1000000)
                .forEach(System.out::println);

        System.out.println("=== Total Transacciones ===");
        System.out.println(servicio.CalcularTotal());

        System.out.println("=== Promedio ===");
        System.out.println(servicio.CalcularPromedio());

        System.out.println("=== Mayor Transaccion ===");

        servicio.ObtenerMayorTransaccion()
            .ifPresent(System.out::println);

        System.out.println("=== Agrupas por Categoria ===");

        servicio.AgruparPorCategoria()
                .forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        System.out.println("=== Usuarios Unicos ===");

        servicio.obtenerUsuariosUnicos()
                .forEach(System.out::println);

        System.out.println("=== Ordenados por Monto ===");

        servicio.ordenarPorMonto()
                .forEach(System.out::println);

        System.out.println("=== Filtro Personalizado ===");

        servicio.filtrar(t -> t.getMonto() > 5000)
        .forEach(System.out::println);


    }
}
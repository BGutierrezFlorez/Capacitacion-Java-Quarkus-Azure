package service;
import model.Transaccion;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class ServicioTransacciones {

    private List<Transaccion> transacciones;
    public ServicioTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    // Filtrar transacciones sospechosas
    public List<Transaccion> ObtenerSospechosas() {
        return transacciones.stream()
                .filter(Transaccion::isSospechosa).collect(Collectors.toList());
    }

    // Filtrar montos Altos
    public List<Transaccion> ObtenerMontosAltos(double monto) {
        return transacciones.stream()
                .filter(t -> t.getMonto()> monto)
                .toList();

    }

    // suma total
    public double CalcularTotal(){
        return transacciones.stream()
                .map(Transaccion::getMonto)
                .reduce(0.0, Double::sum);
    }

    // Promedio
    public double CalcularPromedio(){
        return transacciones.stream()
                .mapToDouble(Transaccion::getMonto)
                .average()
                .orElse(0.0);
    }

    // Obtener transaccion con mayor monto
    public Optional<Transaccion> ObtenerMayorTransaccion(){
        return transacciones.stream()
                .max(Comparator.comparing(Transaccion::getMonto));

    }

    // agrupar por categoria
    public Map<String, List<Transaccion>> AgruparPorCategoria(){
        return transacciones.stream()
                .collect(Collectors.groupingBy(Transaccion::getCategoria));

    }

    // obtener usuarios unicos
    public List<String> obtenerUsuariosUnicos(){
        return transacciones.stream()
                .map(Transaccion::getUsuario)
                .distinct()
                .toList();
    }

    // ordenar por monto
    public List<Transaccion> ordenarPorMonto(){
        return transacciones.stream()
                .sorted(Comparator.comparing(Transaccion::getMonto))
                .toList();
    }

    // uso de Predicate
    public List<Transaccion> filtrar(Predicate<Transaccion> criterio){
        return transacciones.stream()
                .filter(criterio)
                .toList();
    }
}

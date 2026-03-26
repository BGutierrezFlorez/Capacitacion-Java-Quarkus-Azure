public class Ejemplo {
    public static void main(String[] args) {
        // ✅ Polimorfismo correcto
        Transporte miTransporte = new Carro();  // ✅ Sin typo, mayúsculas
        miTransporte.haceDesplazamiento();      // ✅ Llama instancia, no clase

        // ✅ Output esperado:
        // hace desplazamiento siempre
        // pero el carro se queda quieto
    }
}
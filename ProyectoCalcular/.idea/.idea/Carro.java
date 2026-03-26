// ✅ Clase heredera correcta
public class Carro extends Transporte {  // ✅ Mayúscula
    @Override
    public void haceDesplazamiento() {
        super.haceDesplazamiento();  // ✅ Llama al método padre
        System.out.println("pero el carro se queda quieto");  // ✅ Comentario más claro
    }
}

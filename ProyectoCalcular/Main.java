import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Test tester = new Test();

        // ---- Datos del círculo ----
        String colorCirculo = JOptionPane.showInputDialog(null, "Ingrese el color del círculo");
        double radioCirculo = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingrese el radio del círculo")
        );

        Circulo circulo = new Circulo(colorCirculo, radioCirculo);

        // ---- Datos del triángulo ----
        String colorTriangulo = JOptionPane.showInputDialog(null, "Ingrese el color del triángulo");
        double baseTriangulo = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingrese la base del triángulo")
        );
        double alturaTriangulo = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingrese la altura del triángulo")
        );

        Triangulo triangulo = new Triangulo(colorTriangulo, baseTriangulo, alturaTriangulo);

        // ---- Mostrar resultados ----
        tester.mostrarDatos(circulo);
        tester.mostrarDatos(triangulo);
    }
}

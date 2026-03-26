public class Triangulo extends Figura {
    private double base;
    private double altura;

    public Triangulo(String color, double base, double altura){
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public double getBase(){
        return base;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getAltura(){
        return altura;

    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }

    @Override
    public String mostrarInfo() {
        return "Figura: Triángulo\n" +
               "Color: " + color + "\n" +
               "Base: " + base + "\n" +
               "Altura: " + altura + "\n" +
               "Área: " + ((base * altura) / 2);
    }
}

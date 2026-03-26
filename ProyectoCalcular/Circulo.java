public class Circulo extends Figura {
    private double radio;
    
    public Circulo(String color, double radio){
        super(color);
        this.radio = radio;

    }

    public double getRadio(){
        return radio;
    }

    public void setRadio(double radio){
        this.radio = radio;

    }

    @Override
    public String mostrarInfo(){
        return "Figura: Circulo\n" +
                "Color: " + color + "\n" +
                "Radio: " + radio + "\n" +
                "Area: "  + (Math.PI * radio * radio);
                        
    }
}

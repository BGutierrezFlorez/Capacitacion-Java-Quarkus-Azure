public class Figura {
    protected String color;

     public Figura(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    // Metodo que sera sobreescrito
    public String mostrarInfo(){
        return "color: " + color;
    }

}


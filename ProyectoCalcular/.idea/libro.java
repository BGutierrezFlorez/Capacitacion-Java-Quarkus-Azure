public class libro {
    private String titulo;
    private String autor;
    private double precio;
    private int cantidadEnStock;

    public libro(){
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;

    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public double getPrecio(){
    return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getCantidadEnStock(){
        return cantidadEnStock;

    }

    public void setCantidadEnStock(int cantidadEnStock){
        if(cantidadEnStock > 0){
            this.cantidadEnStock = cantidadEnStock;
        } else {
            throw new IllegalArgumentException("el valor debe ser mayor a 0");
        }
    }

    public void mostrarInfo(){
        System.out.println("titulo:" + titulo);
        System.out.println("autor:" + autor);
        System.out.println("precio:" + precio);
        System.out.println("cantidadEnStock:" + cantidadEnStock);
    }

}

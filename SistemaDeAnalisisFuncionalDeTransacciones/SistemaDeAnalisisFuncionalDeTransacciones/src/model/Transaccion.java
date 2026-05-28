package model;

import java.time.LocalDate;

public class Transaccion {

    private int id;
    private String usuario;
    private double monto;
    private String categoria;
    private LocalDate fecha;
    private boolean sospechosa;

    public Transaccion(int id, String usuario, double monto,
                       String categoria, LocalDate fecha,
                       boolean sospechosa) {

        this.id = id;
        this.usuario = usuario;
        this.monto = monto;
        this.categoria = categoria;
        this.fecha = fecha;
        this.sospechosa = sospechosa;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getMonto() {
        return monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Convención Java para boolean
    public boolean isSospechosa() {
        return sospechosa;
    }

    @Override
    public String toString() {

        return "Transaccion{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", monto=" + monto +
                ", categoria='" + categoria + '\'' +
                ", fecha=" + fecha +
                ", sospechosa=" + sospechosa +
                '}';
    }
}
package com.cowshop.project.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", updatable = false, nullable = false)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nombre;

    @Column(nullable = false, unique = true, length = 20)
    public String cedula;

    @Column(nullable = false, unique = true, length = 150)
    public String correo;

    @Column(length = 20)
    public String celular;

    @Column(name = "tipo_usuario", nullable = false, length = 50)
    public String tipoUsuario;

    @Column(name = "contrasena", nullable = false)
    @JsonProperty("contrasena")
    public String contrasena;

    @Column(name = "fecha_nacimiento")
    public String fechaNacimiento;

    @Column(name = "id_membresia")
    public Integer idMembresia;

    @Column(name = "id_rol")
    public Integer idRol;

    @Column(name = "estado")
    public Boolean estado;


    public String getNombre() {
        return this.nombre;
    }

    public Long getID_Usuario() {
        return this.id;
    }

    public void setID_Usuario(int id) {
        this.id = (long) id;
    }

    public String getTipo_Usuario() {
        return this.tipoUsuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }
}

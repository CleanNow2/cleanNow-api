package upao.edu.cleannow_api.model;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellido",nullable = false, length = 50)
    private String apellido;
    @Column(name = "email",nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "dni",nullable = false, unique = true)
    private String dni;
    @Column(name = "numberPhone",nullable = false, unique = true)
    private int numberPhone;
    @Column(name = "cuidad", nullable = false)
    private String ciudad;
    @Column(name = "password",nullable = false, length = 20)
    private String password;
    @Column(name = "rol",nullable = false, length = 20)
    private String rol;


    public Usuario(long idUser, String nombre, String apellido, String email, String dni, int numberPhone, String ciudad, String password, String rol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.numberPhone = numberPhone;
        this.ciudad = ciudad;
        this.password = password;
        this.rol = rol;
    }
}


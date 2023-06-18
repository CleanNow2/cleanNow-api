package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity


public class Cliente{
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellido",nullable = false, length = 50)
    private String apellido;
    @Column(name = "dni",nullable = false, unique = true)
    private int dni;
    @Column(name = "numberPhone",nullable = false, unique = true)
    private int numberPhone;
    @Column(name = "email",nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "password",nullable = false, length = 20)
    private String password;

    public Cliente(String nombre, String apellido, int dni, int numberPhone, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numberPhone = numberPhone;
        this.email = email;
        this.password = password;
    }
}

package upao.edu.cleannow_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 9999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long idUser;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellido",nullable = false, length = 50)
    private String apellido;
    @Column(name = "dni",nullable = false, length = 8)
    private String dni;
    @Column(name = "numberPhone",nullable = false, unique = true)
    private String numberPhone;
    @Column(name = "cuidad", nullable = false)
    private String ciudad;
    @Column(name = "email",nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "password",nullable = false, length = 50)
    private String password;
    private boolean enable = true;
    private String perfil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

}


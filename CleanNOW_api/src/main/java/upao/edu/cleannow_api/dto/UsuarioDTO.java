package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.UsuarioRol;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {

    private Integer idUser;

    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Email
    @Size(min = 3, max = 50)
    private String email;

    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[A-Za-z ]*")
    private String nombre;


    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[A-Za-z ]*")
    private String apellido;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "\\d+")
    private String dni;

    @NotNull
    @Pattern(regexp = "9\\d{8}")
    @Size(min = 9, max = 9)
    private String numberPhone;

    @NotNull
    @Size(min = 3, max = 50)
    private String ciudad;

    @NotNull
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;

    private boolean enable = true;

    private String perfil;

    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
}

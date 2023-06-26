package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

    private Integer idUser;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[A-Za-z ]*")
    private String nombre;


    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[A-Za-z ]*")
    private String apellido;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    @Pattern(regexp = "\\d+")
    private String dni;

    @NotNull
    @Pattern(regexp = "9\\d{8}")
    @Size(min = 9, max = 9)
    private String numberPhone;

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 3, max = 50)
    private String email;


    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String ciudad;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String rol;

    @Size(min = 0, max = 100)
    private String preferencias;
}

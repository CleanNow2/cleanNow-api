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

    private Integer idCliente;

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
    @Min(value = 10000000)
    @Max(value = 99999999)
    private int dni;

    @NotNull
    @Min(value = 900000000)
    @Max(value = 999999999)
    private int numberPhone;

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 3, max = 50)
    private String email;


    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
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

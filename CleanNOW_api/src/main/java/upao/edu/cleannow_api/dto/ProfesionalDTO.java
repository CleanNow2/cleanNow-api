package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.Servicio;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesionalDTO extends UsuarioDTO{
    @NotNull
    @Size(min = 3, max = 50)
    private String experiencia;

    private Set<String> especialidades = new HashSet<>();

    private Set<Servicio> servicios = new HashSet<>();

}

package upao.edu.cleannow_api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.Servicio;
import upao.edu.cleannow_api.model.SolicitudServicio;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends UsuarioDTO{

    @Size(min = 0, max = 100)
    private String preferencias;

    private Set<SolicitudServicio> solicitudes = new HashSet<>();

    private Set<Servicio> servicios = new HashSet<>();

}

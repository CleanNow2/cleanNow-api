package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.SolicitudServicio;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoServcioDTO {
    private long idTipoServicio;
    private String nombre;
    private String descripcion;
    private double precio;
    private Set<SolicitudServicio> solicitudes;
}

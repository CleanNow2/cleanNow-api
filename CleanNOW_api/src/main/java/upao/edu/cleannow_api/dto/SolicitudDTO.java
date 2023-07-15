package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.TipoServicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitudDTO {
    private long idSolicitud;
    private LocalDateTime fechaSolicitud = LocalDateTime.now();
    private String ciudad;
    private String direccion;
    private String distrito;
    private String detallesCasa;
    private String referencias;
    private LocalDate fechaServicio;
    private LocalTime horario;
    private String detallesServicio;
    private String estado;
    private TipoServicio tipoServicio;
    private int nroHoras;
    private Cliente cliente;
}

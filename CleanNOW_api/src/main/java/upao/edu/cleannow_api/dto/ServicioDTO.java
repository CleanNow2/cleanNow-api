package upao.edu.cleannow_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.Profesional;
import upao.edu.cleannow_api.model.SolicitudServicio;
import upao.edu.cleannow_api.model.TipoServicio;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicioDTO {
    private long idService;

    private Cliente idCliente;

    private Profesional idProfesional;

    private String estado;

    private LocalDateTime fechaServicio;

    private TipoServicio tipoServicio;

    private int duracion;

    private SolicitudServicio solicitudServicio;

    private Cliente cliente;

    private Profesional profesional;
}

package upao.edu.cleannow_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SolicitudServicio {
    @Id
    @SequenceGenerator(
            name = "solicitud_sequence",
            sequenceName = "solicitud_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "solicitud_sequence"
    )
    private long idSolicitud;
    @Column(name = "fechaSolicitud")
    private LocalDateTime fechaSolicitud;
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Column(name = "distrito", nullable = false, length = 50)
    private String distrito;
    @Column(name = "detallesCasa", nullable = false, length = 50)
    private String detallesCasa;
    @Column(name = "referencias", nullable = false, length = 80)
    private String referencias;
    @Column(name = "fechaServicio", nullable = false)
    private LocalDate fechaServicio;
    @Column(name = "horario", nullable = false)
    private LocalTime horario;
    @Column(name = "detallesServicio", nullable = false,length = 300)
    private String detallesServicio;
    @Column(name = "estado")
    private String estado;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "idTipoServicio")
    private TipoServicio tipoServicio;
    @Column(name = "nroHoras", nullable = false)
    private int nroHoras;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "idCliente")
    private Cliente cliente;


}

package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @SequenceGenerator(
            name = "service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1,
            initialValue = 99
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )
    private long idService;

    @OneToOne
    private Cliente idCliente;

    @OneToOne
    private Profesional idProfesional;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @Column(name = "fechaServicio", nullable = false)
    private LocalDateTime fechaServicio;
    @OneToOne
    private TipoServicio tipoServicio;
    @Column(name = "duracion", nullable = false)
    private int duracion;

    @OneToOne
    private SolicitudServicio solicitudServicio;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "idProfesional")
    private Profesional profesional;


}

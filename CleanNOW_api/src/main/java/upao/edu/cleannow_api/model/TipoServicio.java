package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class TipoServicio {
    @Id
    @SequenceGenerator(
            name = "typeService_sequence",
            sequenceName = "typeService_sequence",
            allocationSize = 1,
            initialValue = 999999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "typeService_sequence"
    )
    private long idTipoServicio;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private double precio;
    @OneToMany
    private Set<SolicitudServicio> solicitudes;
}

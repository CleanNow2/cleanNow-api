package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Solicitud {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name="FK_Solicitud_Cliente"))
    private Cliente cliente;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "descripcion", nullable = false)
    private String descipcion;

    @Column(name = "estado", nullable = false, length = 11)
    private String estado;

    @OneToOne(mappedBy = "solicitud")
    private Servicio servicio;

}

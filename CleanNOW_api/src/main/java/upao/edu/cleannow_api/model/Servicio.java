package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Servicio {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_Servicio_Cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_profesional", nullable = false, foreignKey = @ForeignKey(name = "FK_Servicio_Profesional"))
    private Profesional profesional;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(name ="duracion", nullable = false)
    private String duracion;

    @Column(name = "costo", nullable = false)
    private double costo;

    @OneToOne
    @JoinColumn(name = "id_solicitud", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_Servicio_Solicitud"))
    private Solicitud solicitud;

    @OneToOne(mappedBy = "servicio")
    private Comentario comentario;

}

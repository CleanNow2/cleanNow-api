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
public class Comentario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name ="fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_Comentario_Usuario"))
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_servicio", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_Comentario_Servicio"))
    private Servicio servicio;


}

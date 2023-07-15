package upao.edu.cleannow_api.model;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class DetallePago {
    @Id
    @SequenceGenerator(
            name = "detallePago_sequence",
            sequenceName = "detallePago_sequence",
            allocationSize = 1,
            initialValue = 99999999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "detallePago_sequence"
    )
    private long idDetallePago;
    @OneToOne
    private Servicio servicio;
    @Column(name = "formaPago",nullable = false, length = 50)
    private String formaPago;
}

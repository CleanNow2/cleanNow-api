package upao.edu.cleannow_api.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Profesional extends Usuario{
    @Column(name = "experiencia", nullable = false, length = 200)
    private String experiencia;
    @Column(name = "especialidades")
    private Set<String> especialidades = new HashSet<>();
    @OneToMany
    private Set<Servicio> servicios = new HashSet<>();
}

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
public class Cliente extends Usuario{
    @Column(name = "preferencias")
    private String preferencias;
    @OneToMany
    private Set<SolicitudServicio> solicitudes = new HashSet<>();
    @OneToMany
    private Set<Servicio> servicios = new HashSet<>();
}

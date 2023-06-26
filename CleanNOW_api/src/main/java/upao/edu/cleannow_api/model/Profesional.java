package upao.edu.cleannow_api.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.dynamic.loading.ClassInjector;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table
public class Profesional extends Usuario {

    @Column(name = "experiencia", nullable = false)
    private String experiencia;
    @Column(name = "especialidades", nullable = false)
    private String especialidades;
    @Column(name = "tarifa", nullable = false)
    private double tarifa;

    public Profesional(long idUser, String nombre, String apellido, String email, String dni, int numberPhone, String ciudad, String password, String rol, String experiencia, String especialidades, double tarifa) {
        super(idUser, nombre, apellido, email, dni, numberPhone, ciudad, password, rol);
        this.experiencia = experiencia;
        this.especialidades = especialidades;
        this.tarifa = tarifa;
    }
}

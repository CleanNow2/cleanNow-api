package upao.edu.cleannow_api.model;

import jakarta.persistence.*;
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
public class Cliente extends Usuario {
    @Column(name = "preferencias")
    private String preferencias;

    public Cliente(long idUser, String nombre, String apellido, String email, String dni, String numberPhone, String ciudad, String password, String rol, String preferencias) {
        super(idUser, nombre, apellido, email, dni, numberPhone, ciudad, password, rol);
        this.preferencias = preferencias;
    }
}

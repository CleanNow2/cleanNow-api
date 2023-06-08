package upao.edu.cleannow_api.repository;

import org.springframework.data.jpa.repository.Query;
import upao.edu.cleannow_api.model.Cliente;

import java.util.List;

public interface IClienteRepository extends IGenericRepository<Cliente, Integer> {

    boolean existsByNombreOrEmail(String name, String apellido);
    boolean existsByNombreAndEmail(String name, String email);


    @Query("FROM Cliente c WHERE c.nombre = ?1 AND c.email LIKE %?2%")
    List<Cliente> getByNameAndDescription(String name, String description);
}
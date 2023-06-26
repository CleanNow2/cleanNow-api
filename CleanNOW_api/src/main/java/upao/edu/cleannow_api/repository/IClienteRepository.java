package upao.edu.cleannow_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upao.edu.cleannow_api.model.Cliente;

import java.util.List;

public interface IClienteRepository extends IGenericRepository<Cliente, Integer> {

    boolean existsByDniOrEmailOrNumberPhone(String dni,String email, int numberPhone);
    boolean existsByDniAndEmailAndNumberPhone(String dni, String email, int numberPhone);

}
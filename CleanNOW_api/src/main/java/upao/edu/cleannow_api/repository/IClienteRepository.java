package upao.edu.cleannow_api.repository;

import upao.edu.cleannow_api.model.Cliente;

public interface IClienteRepository extends IGenericRepository<Cliente, Integer> {

    boolean existsByDniOrNumberPhone(String dni,String numberPhone);

}
package upao.edu.cleannow_api.repository;

import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.Usuario;

public interface IUsuarioRepository extends IGenericRepository<Usuario,Integer>{

    public Usuario findByUsername(String username);
}

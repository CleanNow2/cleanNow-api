package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.model.UsuarioRol;

import java.util.Set;

public interface IUsuarioService extends ICRUD<Usuario, Integer>{

    public Usuario save(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception, DataAlreadyExistsException;
}

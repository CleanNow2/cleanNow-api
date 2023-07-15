package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.model.UsuarioRol;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IRolRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.IUsuarioService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    private final IUsuarioRepository repo;

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IRolRepository rolRepository;

    @Override
    protected IGenericRepository<Usuario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Usuario save(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioLocal != null) {
            throw new DataAlreadyExistsException("Usuario ya registrado.");
        } else {
            for (UsuarioRol usuarioRol : usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }

        return super.save(usuarioLocal);
    }

    @Override
    public Usuario update(Usuario usuario, Integer idUsuario) throws Exception {
        Usuario usuarioUpdate = getRepo().findById(idUsuario).orElseThrow(() -> new ModelNotFoundException("El profesional con id " + idUsuario + " no existe."));

        usuarioUpdate.setPassword(usuario.getPassword());

        return super.update(usuarioUpdate, idUsuario);
    }

    @Override
    public void delete(Integer id) throws Exception {
        super.delete(id);
    }

    @Override
    public List<Usuario> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Usuario readById(Integer id) throws Exception, DataAlreadyExistsException {
        return super.readById(id);
    }
}

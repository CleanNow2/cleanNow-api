package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.ICRUD;
import upao.edu.cleannow_api.service.IUsuarioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    private final IUsuarioRepository repo;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    protected IGenericRepository<Usuario, Integer> getRepo() {
        return repo;
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        String dni= usuario.getDni();
        String email = usuario.getEmail();
        String numberPhone = usuario.getNumberPhone();

        if (isUsuarioDuplicate(dni, email, numberPhone)) {
            throw new DataAlreadyExistsException("Dni y/o Email y/o número ya registrado.");
        }

        return super.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario, Integer idUsuario) throws Exception {
        Usuario usuarioUpdate = getRepo().findById(idUsuario).orElseThrow( () -> new ModelNotFoundException("El profesional con id " + idUsuario + " no existe."));

        usuarioUpdate.setNombre(usuario.getNombre());
        usuarioUpdate.setApellido(usuario.getApellido());
        usuarioUpdate.setPassword(usuario.getPassword());
        usuarioUpdate.setNumberPhone(usuario.getNumberPhone());
        usuarioUpdate.setEmail(usuario.getEmail());

        return super.update(usuarioUpdate,idUsuario);
    }

    @Override
    public void delete(Integer id) throws Exception{
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

    @Override
    public boolean isUsuarioDuplicate(String dni, String email,String numberPhone) {
        return repo.existsByDniOrEmailOrNumberPhone(dni, email, numberPhone);
    }
}

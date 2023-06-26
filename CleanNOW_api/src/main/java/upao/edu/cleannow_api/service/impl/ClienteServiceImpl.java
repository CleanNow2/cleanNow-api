package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.internal.util.type.PrimitiveWrapperHelper;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.repository.IClienteRepository;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.IClienteService;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    private final IClienteRepository repo;
    private final IUsuarioRepository repo2;

    @Autowired
    private IUsuarioRepository clienteRepository;

    @Override
    protected IGenericRepository<Cliente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        Usuario usuario = cliente;
        String dni= usuario.getDni();
        String email = usuario.getEmail();
        int numberPhone = usuario.getNumberPhone();

        if (isUsuarioDuplicate(dni, email, numberPhone)) {
            throw new DataAlreadyExistsException("Dni y/o Email y/o número ya registrado.");
        }

        return super.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Integer idCliente) throws Exception {
        Cliente clienteUpdate = getRepo().findById(idCliente).orElseThrow( () -> new ModelNotFoundException("El cliente con id " + idCliente + " no existe."));

        clienteUpdate.setNombre(cliente.getNombre());
        clienteUpdate.setApellido(cliente.getApellido());
        clienteUpdate.setPassword(cliente.getPassword());
        clienteUpdate.setNumberPhone(cliente.getNumberPhone());
        clienteUpdate.setEmail(cliente.getEmail());

        return super.update(clienteUpdate,idCliente);
    }

    @Override
    public void delete(Integer id) throws Exception{
        super.delete(id);
    }

    @Override
    public List<Cliente> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Cliente readById(Integer id) throws Exception, DataAlreadyExistsException{
        return super.readById(id);
    }

    @Override
    public boolean isClienteDuplicate(String dni, String email, int numberPhone) {
        return repo.existsByDniOrEmailOrNumberPhone(dni, email, numberPhone);
    }

    @Override
    public boolean isClienteDuplicateUpdate(String dni, String email, int numberPhone) {
        return repo.existsByDniAndEmailAndNumberPhone(dni, email, numberPhone);
    }

    public boolean isUsuarioDuplicate(String dni, String email, int numberPhone) {
        return repo2.existsByDniOrEmailOrNumberPhone(dni, email, numberPhone);
    }
}
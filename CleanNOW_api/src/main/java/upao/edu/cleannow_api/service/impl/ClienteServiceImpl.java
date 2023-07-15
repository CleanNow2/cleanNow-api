package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.repository.IClienteRepository;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.IClienteService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    private final IClienteRepository repo;

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    protected IGenericRepository<Cliente, Integer> getRepo() {

        return repo;
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        String dni= cliente.getDni();
        String numberPhone= cliente.getNumberPhone();

        if (isClienteDuplicate(dni, numberPhone)) {
            throw new DataAlreadyExistsException("Dni y/o número ya registrado.");
        }

        return super.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Integer idCliente) throws Exception {
        Cliente clienteUpdate = getRepo().findById(idCliente).orElseThrow( () -> new ModelNotFoundException("El cliente con id " + idCliente + " no existe."));

        clienteUpdate.setNombre(cliente.getNombre());
        clienteUpdate.setApellido(cliente.getApellido());
        clienteUpdate.setNumberPhone(cliente.getNumberPhone());

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
    public boolean isClienteDuplicate(String dni, String numberPhone) {
        return repo.existsByDniOrNumberPhone(dni, numberPhone);
    }

}
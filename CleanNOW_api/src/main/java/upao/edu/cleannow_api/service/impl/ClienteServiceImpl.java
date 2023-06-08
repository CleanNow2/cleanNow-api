package upao.edu.cleannow_api.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.repository.IClienteRepository;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.service.IClienteService;



@Service
@RequiredArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    private final IClienteRepository repo;


    @Override
    protected IGenericRepository<Cliente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        String name = cliente.getNombre();
        String email = cliente.getEmail();

        if (isClienteDuplicate(name, email)) {
            throw new DataAlreadyExistsException("el cliente ya existe con el nombre y/o email que has ingresado.");
        }

        return super.save(cliente);
    }

    public boolean isClienteDuplicate(String name, String email) {
        return repo.existsByNombreOrEmail(name, email);
    }
}
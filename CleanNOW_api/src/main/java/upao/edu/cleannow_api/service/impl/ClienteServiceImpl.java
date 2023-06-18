package upao.edu.cleannow_api.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    protected IGenericRepository<Cliente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        int dni = cliente.getDni();
        int phone = cliente.getNumberPhone();
        String email = cliente.getEmail();

        if (isClienteDuplicate(dni, phone, email)) {
            throw new DataAlreadyExistsException("el cliente ya existe con el dni o número de celular o email");
        }
        return super.save(cliente);
    }

    public boolean isClienteDuplicate(int dni, int numberPhone, String email) {
        return repo.existsByDniOrNumberPhoneOrEmail(dni,numberPhone, email);
    }

    @Override
    public boolean existsById(Integer id){
        return clienteRepository.existsById(id);
    }
}
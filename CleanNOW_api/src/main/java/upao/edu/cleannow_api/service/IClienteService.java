package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.model.Cliente;

public interface IClienteService extends ICRUD<Cliente, Integer>{
    public boolean isClienteDuplicate(String name, String email);
}
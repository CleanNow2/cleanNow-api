package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer>{
    public boolean isUsuarioDuplicate(String dni, String email, String numberPhone);
}

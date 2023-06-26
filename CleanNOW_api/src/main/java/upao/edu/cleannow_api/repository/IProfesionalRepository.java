package upao.edu.cleannow_api.repository;

import upao.edu.cleannow_api.model.Profesional;

public interface IProfesionalRepository extends IGenericRepository<Profesional, Integer> {
    boolean existsByDniOrEmailOrNumberPhone(String dni,String email, int numberPhone);
    boolean existsByDniAndEmailAndNumberPhone(String dni, String email, int numberPhone);
}

package upao.edu.cleannow_api.repository;

import upao.edu.cleannow_api.model.Profesional;

public interface IProfesionalRepository extends IGenericRepository<Profesional, Integer> {
    boolean existsByDniOrNumberPhone(String dni,String numberPhone);
    boolean existsByDniAndNumberPhone(String dni, String numberPhone);
}

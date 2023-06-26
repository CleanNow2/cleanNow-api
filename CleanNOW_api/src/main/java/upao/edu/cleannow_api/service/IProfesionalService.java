package upao.edu.cleannow_api.service;

import upao.edu.cleannow_api.model.Profesional;

public interface IProfesionalService extends ICRUD<Profesional, Integer>{
    public boolean isProfesionalDuplicate(String dni, String email, String numberPhone);
    public boolean isProfesionalDuplicateUpdate(String dni, String email, String numberPhone);

}

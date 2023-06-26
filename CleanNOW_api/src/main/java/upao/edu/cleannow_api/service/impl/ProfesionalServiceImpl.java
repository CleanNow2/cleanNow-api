package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Profesional;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IProfesionalRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.IProfesionalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesionalServiceImpl extends CRUDImpl<Profesional, Integer> implements IProfesionalService{

    private final IProfesionalRepository repo;
    private final IUsuarioRepository repo2;

    @Autowired
    private IProfesionalRepository profesionalRepository;

    @Override
    protected IGenericRepository<Profesional, Integer> getRepo() {
        return repo;
    }

    @Override
    public Profesional save(Profesional profesional) throws Exception {
        Usuario usuario = profesional;
        String dni= usuario.getDni();
        String email = usuario.getEmail();
        int numberPhone = usuario.getNumberPhone();

        if (isUsuarioDuplicate(dni, email, numberPhone)) {
            throw new DataAlreadyExistsException("Dni y/o Email y/o número ya registrado.");
        }

        return super.save(profesional);
    }

    @Override
    public Profesional update(Profesional profesional, Integer idProfesional) throws Exception {
        Profesional profesionalUpdate = getRepo().findById(idProfesional).orElseThrow( () -> new ModelNotFoundException("El profesional con id " + idProfesional + " no existe."));

        profesionalUpdate.setNombre(profesional.getNombre());
        profesionalUpdate.setApellido(profesional.getApellido());
        profesionalUpdate.setPassword(profesional.getPassword());
        profesionalUpdate.setNumberPhone(profesional.getNumberPhone());
        profesionalUpdate.setEmail(profesional.getEmail());
        profesionalUpdate.setEspecialidades(profesional.getEspecialidades());
        profesionalUpdate.setExperiencia(profesional.getExperiencia());
        profesionalUpdate.setTarifa(profesional.getTarifa());

        return super.update(profesionalUpdate,idProfesional);
    }

    @Override
    public void delete(Integer id) throws Exception{
        super.delete(id);
    }

    @Override
    public List<Profesional> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Profesional readById(Integer id) throws Exception, DataAlreadyExistsException{
        return super.readById(id);
    }

    @Override
    public boolean isProfesionalDuplicate(String dni, String email, int numberPhone) {
        return repo.existsByDniOrEmailOrNumberPhone(dni, email, numberPhone);
    }

    @Override
    public boolean isProfesionalDuplicateUpdate(String dni, String email, int numberPhone) {
        return repo.existsByDniAndEmailAndNumberPhone(dni, email, numberPhone);
    }


    public boolean isUsuarioDuplicate(String dni, String email, int numberPhone) {
        return repo2.existsByDniOrEmailOrNumberPhone(dni, email, numberPhone);
    }
}

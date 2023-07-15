package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Servicio;
import upao.edu.cleannow_api.model.SolicitudServicio;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.IServicioLimpiezaRepository;
import upao.edu.cleannow_api.repository.ISolicitudRepository;
import upao.edu.cleannow_api.service.IServicioLimpiezaService;
import upao.edu.cleannow_api.service.ISolicitudService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioLimpiezaServiceImpl extends CRUDImpl<Servicio, Integer> implements IServicioLimpiezaService {
    private final IServicioLimpiezaRepository repo;

    @Autowired
    private IServicioLimpiezaRepository servicioLimpiezaRepository;

    @Override
    protected IGenericRepository<Servicio, Integer> getRepo() {

        return repo;
    }

    @Override
    public Servicio save(Servicio servicio) throws Exception, DataAlreadyExistsException {
        return super.save(servicio);
    }
    @Override
    public Servicio update(Servicio servicio,Integer idServicio) throws Exception{
        Servicio servicioUpdate = getRepo().findById(idServicio).orElseThrow( () -> new ModelNotFoundException("El servicio con id " + idServicio + " no existe."));

        servicioUpdate.setEstado(servicio.getEstado());

        return super.update(servicioUpdate,idServicio);
    }
    @Override
    public List<Servicio> readAll() throws Exception{
        return super.readAll();
    }
    @Override
    public void delete(Integer id) throws Exception{
        super.delete(id);
    }
    @Override
    public Servicio readById(Integer id) throws Exception, DataAlreadyExistsException{
        return super.readById(id);
    }
}

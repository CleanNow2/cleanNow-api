package upao.edu.cleannow_api.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.TipoServicio;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.ITipoServicioRepository;
import upao.edu.cleannow_api.service.ITipoServicioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl extends CRUDImpl<TipoServicio,Integer> implements ITipoServicioService {
    private final ITipoServicioRepository repo;
    @Autowired
    private ITipoServicioRepository iTipoServicioRepository;
    @Override
    protected IGenericRepository<TipoServicio,Integer> getRepo(){
        return repo;
    }

    public TipoServicio save(TipoServicio tipoServicio) throws Exception, DataAlreadyExistsException{
        return super.save(tipoServicio);
    }

    public TipoServicio update(TipoServicio tipoServicio,Integer idTipo) throws Exception{
        TipoServicio tipoServicioUpdate = getRepo().findById(idTipo).orElseThrow( () -> new ModelNotFoundException("El Tipo de Servicio con id " + idTipo + " no existe."));
        return super.save(tipoServicioUpdate);
    }

    public List<TipoServicio> readAll() throws Exception{
        return super.readAll();
    }

    public void delete(Integer idTipo) throws Exception{
        super.delete(idTipo);
    }

    public TipoServicio readById(Integer idTipo) throws Exception, DataAlreadyExistsException{
        return super.readById(idTipo);
    }
}


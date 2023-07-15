package upao.edu.cleannow_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.exception.ModelNotFoundException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.SolicitudServicio;
import upao.edu.cleannow_api.repository.IClienteRepository;
import upao.edu.cleannow_api.repository.IGenericRepository;
import upao.edu.cleannow_api.repository.ISolicitudRepository;
import upao.edu.cleannow_api.repository.IUsuarioRepository;
import upao.edu.cleannow_api.service.ISolicitudService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl extends CRUDImpl<SolicitudServicio, Integer> implements ISolicitudService {
    private final ISolicitudRepository repo;

    @Autowired
    private ISolicitudRepository solicitudRepository;

    @Override
    protected IGenericRepository<SolicitudServicio, Integer> getRepo() {

        return repo;
    }
    @Override
    public SolicitudServicio save(SolicitudServicio solicitudServicio) throws Exception, DataAlreadyExistsException{
        Cliente cliente = new Cliente();
        cliente.setIdUser(10007);

        solicitudServicio.setFechaSolicitud(LocalDateTime.now());
        solicitudServicio.setEstado("En Espera");
        solicitudServicio.setCliente(cliente);
        return super.save(solicitudServicio);
    }
    @Override
    public SolicitudServicio update(SolicitudServicio solicitudServicio,Integer idSolicitud) throws Exception{
        SolicitudServicio solicitudServicioUpdate = getRepo().findById(idSolicitud).orElseThrow( () -> new ModelNotFoundException("La solicitud con id " + idSolicitud + " no existe."));

        solicitudServicioUpdate.setDetallesServicio(solicitudServicio.getDetallesServicio());
        solicitudServicioUpdate.setDistrito(solicitudServicio.getDistrito());
        solicitudServicioUpdate.setCiudad(solicitudServicio.getCiudad());
        solicitudServicioUpdate.setDireccion(solicitudServicio.getDireccion());
        solicitudServicioUpdate.setFechaServicio(solicitudServicio.getFechaServicio());
        solicitudServicioUpdate.setHorario(solicitudServicio.getHorario());
        solicitudServicioUpdate.setDetallesCasa(solicitudServicio.getDetallesCasa());
        solicitudServicioUpdate.setReferencias(solicitudServicio.getReferencias());
        solicitudServicioUpdate.setEstado(solicitudServicio.getEstado());

        return super.update(solicitudServicioUpdate,idSolicitud);
    }
    @Override
    public List<SolicitudServicio> readAll() throws Exception{
        return super.readAll();
    }
    @Override
    public void delete(Integer id) throws Exception{
        super.delete(id);
    }
    @Override
    public SolicitudServicio readById(Integer id) throws Exception, DataAlreadyExistsException{
        return super.readById(id);
    }
}

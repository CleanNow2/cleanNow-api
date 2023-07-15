package upao.edu.cleannow_api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import upao.edu.cleannow_api.dto.*;
import upao.edu.cleannow_api.model.*;

@Configuration
public class MapperConfig {

    @Primary
    @Bean("UsuarioMapper")
    public ModelMapper UsuarioMapper() {
        ModelMapper mapper = new ModelMapper();

        TypeMap<UsuarioDTO, Usuario> typeMap1 = mapper.createTypeMap(UsuarioDTO.class, Usuario.class);
        TypeMap<Usuario, UsuarioDTO> typeMap2 = mapper.createTypeMap(Usuario.class, UsuarioDTO.class);

        typeMap1.addMapping(UsuarioDTO::getUsername, (dest, v) -> dest.setUsername((String) v));
        typeMap2.addMapping(Usuario::getUsername, (dest, v) -> dest.setUsername((String) v));

        typeMap1.addMapping(UsuarioDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Usuario::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(UsuarioDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Usuario::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(UsuarioDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Usuario::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(UsuarioDTO::getDni, (dest, v) -> dest.setDni((String) v));
        typeMap2.addMapping(Usuario::getDni, (dest, v) -> dest.setDni((String) v));

        typeMap1.addMapping(UsuarioDTO::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));
        typeMap2.addMapping(Usuario::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));

        typeMap1.addMapping(UsuarioDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Usuario::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(UsuarioDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Usuario::getCiudad, (dest, v) -> dest.setCiudad((String) v));




        return mapper;
    }

    @Bean("ClienteMapper")
    public ModelMapper clienteMapper() {
        ModelMapper mapper = new ModelMapper();

        TypeMap<ClienteDTO, Cliente> typeMap1 = mapper.createTypeMap(ClienteDTO.class, Cliente.class);
        TypeMap<Cliente, ClienteDTO> typeMap2 = mapper.createTypeMap(Cliente.class, ClienteDTO.class);
        //super(idUser, nombre, apellido, dni, numberPhone, email, password)

        typeMap1.addMapping(ClienteDTO::getUsername, (dest, v) -> dest.setUsername((String) v));
        typeMap2.addMapping(Cliente::getUsername, (dest, v) -> dest.setUsername((String) v));

        typeMap1.addMapping(ClienteDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Cliente::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(ClienteDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Cliente::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(ClienteDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Cliente::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(ClienteDTO::getDni, (dest, v) -> dest.setDni((String) v));
        typeMap2.addMapping(Cliente::getDni, (dest, v) -> dest.setDni((String) v));

        typeMap1.addMapping(ClienteDTO::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));
        typeMap2.addMapping(Cliente::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));

        typeMap1.addMapping(ClienteDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Cliente::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(ClienteDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Cliente::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(ClienteDTO::getPreferencias, (dest, v) -> dest.setPreferencias((String) v));
        typeMap2.addMapping(Cliente::getPreferencias, (dest, v) -> dest.setPreferencias((String) v));
        return mapper;
    }

    @Bean("ProfesionalMapper")
    public ModelMapper profesionalMapper() {
        ModelMapper mapper = new ModelMapper();

        TypeMap<ProfesionalDTO, Profesional> typeMap1 = mapper.createTypeMap(ProfesionalDTO.class, Profesional.class);
        TypeMap<Profesional, ProfesionalDTO> typeMap2 = mapper.createTypeMap(Profesional.class, ProfesionalDTO.class);

        typeMap1.addMapping(ProfesionalDTO::getUsername, (dest, v) -> dest.setUsername((String) v));
        typeMap2.addMapping(Profesional::getUsername, (dest, v) -> dest.setUsername((String) v));

        typeMap1.addMapping(ProfesionalDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Profesional::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(ProfesionalDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Profesional::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(ProfesionalDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Profesional::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(ProfesionalDTO::getDni, (dest, v) -> dest.setDni((String) v));
        typeMap2.addMapping(Profesional::getDni, (dest, v) -> dest.setDni((String) v));

        typeMap1.addMapping(ProfesionalDTO::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));
        typeMap2.addMapping(Profesional::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));

        typeMap1.addMapping(ProfesionalDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Profesional::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(ProfesionalDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Profesional::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(ProfesionalDTO::getExperiencia, (dest, v) -> dest.setExperiencia((String) v));
        typeMap2.addMapping(Profesional::getExperiencia, (dest, v) -> dest.setExperiencia((String) v));

        return mapper;
    }
    @Bean("ServicioMapper")
    public ModelMapper ServicioMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<ServicioDTO, Servicio> typeMap1 = mapper.createTypeMap(ServicioDTO.class, Servicio.class);
        TypeMap<Servicio, ServicioDTO> typeMap2 = mapper.createTypeMap(Servicio.class, ServicioDTO.class);

        typeMap1.addMapping(ServicioDTO::getEstado, (dest, v) -> dest.setEstado((String) v));
        typeMap2.addMapping(Servicio::getEstado, (dest, v) -> dest.setEstado((String) v));

        return mapper;
    }
    @Bean("SolicitudMapper")
    public ModelMapper SolicitudMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<SolicitudDTO, SolicitudServicio> typeMap1 = mapper.createTypeMap(SolicitudDTO.class, SolicitudServicio.class);
        TypeMap<SolicitudServicio, SolicitudDTO> typeMap2 = mapper.createTypeMap(SolicitudServicio.class, SolicitudDTO.class);

        typeMap1.addMapping(SolicitudDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(SolicitudServicio::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(SolicitudDTO::getDistrito, (dest, v) -> dest.setDistrito((String) v));
        typeMap2.addMapping(SolicitudServicio::getDistrito, (dest, v) -> dest.setDistrito((String) v));

        typeMap1.addMapping(SolicitudDTO::getDetallesCasa, (dest, v) -> dest.setDetallesCasa((String) v));
        typeMap2.addMapping(SolicitudServicio::getDetallesCasa, (dest, v) -> dest.setDetallesCasa((String) v));

        typeMap1.addMapping(SolicitudDTO::getReferencias, (dest, v) -> dest.setReferencias((String) v));
        typeMap2.addMapping(SolicitudServicio::getReferencias, (dest, v) -> dest.setReferencias((String) v));

        typeMap1.addMapping(SolicitudDTO::getDireccion, (dest, v) -> dest.setDireccion((String) v));
        typeMap2.addMapping(SolicitudServicio::getDireccion, (dest, v) -> dest.setDireccion((String) v));

        typeMap1.addMapping(SolicitudDTO::getDetallesServicio, (dest, v) -> dest.setDetallesServicio((String) v));
        typeMap2.addMapping(SolicitudServicio::getDetallesServicio, (dest, v) -> dest.setDetallesServicio((String) v));

        typeMap1.addMapping(SolicitudDTO::getEstado, (dest, v) -> dest.setEstado((String) v));
        typeMap2.addMapping(SolicitudServicio::getEstado, (dest, v) -> dest.setEstado((String) v));

        return mapper;
    }
    @Bean("TipoServicioMapper")
    public ModelMapper TipoServicioMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<TipoServcioDTO, TipoServicio> typeMap1 = mapper.createTypeMap(TipoServcioDTO.class, TipoServicio.class);
        TypeMap<TipoServicio, TipoServcioDTO> typeMap2 = mapper.createTypeMap(TipoServicio.class, TipoServcioDTO.class);

        typeMap1.addMapping(TipoServcioDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(TipoServicio::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(TipoServcioDTO::getDescripcion, (dest, v) -> dest.setDescripcion((String) v));
        typeMap2.addMapping(TipoServicio::getDescripcion, (dest, v) -> dest.setDescripcion((String) v));

        return mapper;
    }
}

package upao.edu.cleannow_api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import upao.edu.cleannow_api.dto.ClienteDTO;
import upao.edu.cleannow_api.dto.ProfesionalDTO;
import upao.edu.cleannow_api.dto.UsuarioDTO;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.Profesional;
import upao.edu.cleannow_api.model.Usuario;

@Configuration
public class MapperConfig {

    @Primary
    @Bean("UsuarioMapper")
    public ModelMapper UsuarioMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<UsuarioDTO, Usuario> typeMap1 = mapper.createTypeMap(UsuarioDTO.class, Usuario.class);
        TypeMap<Usuario, UsuarioDTO> typeMap2 = mapper.createTypeMap(Usuario.class, UsuarioDTO.class);

        typeMap1.addMapping(UsuarioDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Usuario::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(UsuarioDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Usuario::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(UsuarioDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Usuario::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(UsuarioDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Usuario::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(UsuarioDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Usuario::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(UsuarioDTO::getDni, (dest, v) -> dest.setDni((String) v));
        typeMap2.addMapping(Usuario::getDni, (dest, v) -> dest.setDni((String) v));

        typeMap1.addMapping(UsuarioDTO::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));
        typeMap2.addMapping(Usuario::getNumberPhone, (dest, v) -> dest.setNumberPhone((String) v));

        return mapper;
    }

    @Bean("ClienteMapper")
    public ModelMapper clienteMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<ClienteDTO, Cliente> typeMap1 = mapper.createTypeMap(ClienteDTO.class, Cliente.class);
        TypeMap<Cliente, ClienteDTO> typeMap2 = mapper.createTypeMap(Cliente.class, ClienteDTO.class);
        //super(idUser, nombre, apellido, dni, numberPhone, email, password)

        typeMap1.addMapping(ClienteDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Cliente::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(ClienteDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Cliente::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(ClienteDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Cliente::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(ClienteDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Cliente::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(ClienteDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Cliente::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(ClienteDTO::getPreferencias, (dest, v) -> dest.setPreferencias((String) v));
        typeMap2.addMapping(Cliente::getPreferencias, (dest, v) -> dest.setPreferencias((String) v));

        typeMap1.addMapping(ClienteDTO::getRol, (dest, v) -> dest.setRol((String) v));
        typeMap2.addMapping(Cliente::getRol, (dest, v) -> dest.setRol((String) v));
        return mapper;
    }

    @Bean("ProfesionalMapper")
    public ModelMapper profesionalMapper(){
        ModelMapper mapper = new ModelMapper();

        TypeMap<ProfesionalDTO, Profesional> typeMap1 = mapper.createTypeMap(ProfesionalDTO.class, Profesional.class);
        TypeMap<Profesional, ProfesionalDTO> typeMap2 = mapper.createTypeMap(Profesional.class, ProfesionalDTO.class);

        typeMap1.addMapping(ProfesionalDTO::getNombre, (dest, v) -> dest.setNombre((String) v));
        typeMap2.addMapping(Profesional::getNombre, (dest, v) -> dest.setNombre((String) v));

        typeMap1.addMapping(ProfesionalDTO::getApellido, (dest, v) -> dest.setApellido((String) v));
        typeMap2.addMapping(Profesional::getApellido, (dest, v) -> dest.setApellido((String) v));

        typeMap1.addMapping(ProfesionalDTO::getEmail, (dest, v) -> dest.setEmail((String) v));
        typeMap2.addMapping(Profesional::getEmail, (dest, v) -> dest.setEmail((String) v));

        typeMap1.addMapping(ProfesionalDTO::getPassword, (dest, v) -> dest.setPassword((String) v));
        typeMap2.addMapping(Profesional::getPassword, (dest, v) -> dest.setPassword((String) v));

        typeMap1.addMapping(ProfesionalDTO::getCiudad, (dest, v) -> dest.setCiudad((String) v));
        typeMap2.addMapping(Profesional::getCiudad, (dest, v) -> dest.setCiudad((String) v));

        typeMap1.addMapping(ProfesionalDTO::getRol, (dest, v) -> dest.setRol((String) v));
        typeMap2.addMapping(Profesional::getRol, (dest, v) -> dest.setRol((String) v));

        typeMap1.addMapping(ProfesionalDTO::getExperiencia, (dest, v) -> dest.setExperiencia((String) v));
        typeMap2.addMapping(Profesional::getExperiencia, (dest, v) -> dest.setExperiencia((String) v));

        typeMap1.addMapping(ProfesionalDTO::getEspecialidades, (dest, v) -> dest.setEspecialidades((String) v));
        typeMap2.addMapping(Profesional::getEspecialidades, (dest, v) -> dest.setEspecialidades((String) v));

        return mapper;
    }
}

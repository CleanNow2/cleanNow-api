package upao.edu.cleannow_api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import upao.edu.cleannow_api.dto.ClienteDTO;
import upao.edu.cleannow_api.model.Cliente;

@Configuration
public class MapperConfig {

    @Primary
    @Bean("ClienteMapper")
    public ModelMapper modelMapper(){
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

        return mapper;
    }
}

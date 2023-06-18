package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.ClienteDTO;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.repository.IClienteRepository;
import upao.edu.cleannow_api.service.IClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Clientes")
@RequiredArgsConstructor
public class ClienteController {


    private final IClienteService service;

    @Qualifier("clienteMapper")
    private final ModelMapper mapper;


    @PostMapping()
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto) throws Exception {
        Cliente obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> readAll() throws Exception {
        return ResponseEntity.ok(service.readAll());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Integer id)throws Exception{
        if(service.existsById(id)){
            service.delete(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        }else {
            String mensaje = "Cliente no existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }


    }

    /////////////////////convert mapper//////////////////

    private ClienteDTO convertToDto(Cliente obj){
        return mapper.map(obj, ClienteDTO.class);
    }

    private Cliente convertToEntity(ClienteDTO dto){

        return mapper.map(dto, Cliente.class);
    }
}

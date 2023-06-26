package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.ClienteDTO;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.service.IClienteService;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/Clientes")
@RequiredArgsConstructor
public class ClienteController {


    private final IClienteService service;

    @Qualifier("clienteMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClienteDTO dto) throws Exception {
        try {
            Cliente obj = service.save(convertToEntity(dto));
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@Valid @PathVariable("id") Integer idCliente, @RequestBody ClienteDTO dto) throws Exception {
        dto.setIdCliente(idCliente);
        Cliente obj = service.update(convertToEntity(dto), idCliente);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>>  readAll() throws Exception{
        List<ClienteDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Cliente obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private ClienteDTO convertToDto(Cliente obj){
        return mapper.map(obj, ClienteDTO.class);
    }

    private Cliente convertToEntity(ClienteDTO dto){

        return mapper.map(dto, Cliente.class);
    }
}

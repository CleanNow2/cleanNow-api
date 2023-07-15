package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.ServicioDTO;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Servicio;
import upao.edu.cleannow_api.service.IServicioLimpiezaService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Servicios")
@RequiredArgsConstructor
public class ServicioController {


    private final IServicioLimpiezaService service;

    @Qualifier("ServicioMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ServicioDTO dto) throws Exception {
        try {
            Servicio obj = service.save(convertToEntity(dto));
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ServicioDTO dto) throws Exception {
        dto.setIdService(id);
        Servicio obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServicioDTO>>  readAll() throws Exception{
        List<ServicioDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Servicio obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private ServicioDTO convertToDto(Servicio obj){
        return mapper.map(obj, ServicioDTO.class);
    }

    private Servicio convertToEntity(ServicioDTO dto){

        return mapper.map(dto, Servicio.class);
    }
}

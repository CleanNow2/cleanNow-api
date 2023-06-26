package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.ProfesionalDTO;;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Cliente;
import upao.edu.cleannow_api.model.Profesional;
import upao.edu.cleannow_api.service.IProfesionalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Profesionales")
@RequiredArgsConstructor
public class ProfesionalController {


    private final IProfesionalService service;

    @Qualifier("profesionalesMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProfesionalDTO dto) throws Exception {
        try {
            Profesional obj = service.save(convertToEntity(dto));
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesionalDTO> update(@Valid @PathVariable("id") Integer idProfesional, @RequestBody ProfesionalDTO dto) throws Exception {
        dto.setIdCliente(idProfesional);
        Profesional obj = service.update(convertToEntity(dto), idProfesional);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProfesionalDTO>>  readAll() throws Exception{
        List<ProfesionalDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesionalDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Profesional obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private ProfesionalDTO convertToDto(Profesional obj){
        return mapper.map(obj, ProfesionalDTO.class);
    }

    private Profesional convertToEntity(ProfesionalDTO dto){

        return mapper.map(dto, Profesional.class);
    }
}

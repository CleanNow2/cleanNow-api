package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.SolicitudDTO;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.SolicitudServicio;
import upao.edu.cleannow_api.service.ISolicitudService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Solicitudes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SolicitudController {
    private final ISolicitudService service;

    @Qualifier("SolicitudMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody SolicitudDTO dto) throws Exception {
        try {
            SolicitudServicio obj = service.save(convertToEntity(dto));
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SolicitudDTO dto) throws Exception {
        dto.setIdSolicitud(id);
        SolicitudServicio obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>>  readAll() throws Exception{
        List<SolicitudDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> readById(@PathVariable("id") Integer id) throws Exception{
        SolicitudServicio obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private SolicitudDTO convertToDto(SolicitudServicio obj){
        return mapper.map(obj, SolicitudDTO.class);
    }

    private SolicitudServicio convertToEntity(SolicitudDTO dto){

        return mapper.map(dto, SolicitudServicio.class);
    }
}

package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.TipoServcioDTO;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.TipoServicio;
import upao.edu.cleannow_api.service.ITipoServicioService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/TiposServicios")
@RequiredArgsConstructor
public class TipoServicioController {
    private final ITipoServicioService service;

    @Qualifier("TipoServicioMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TipoServcioDTO dto) throws Exception {
        try {
            TipoServicio obj = service.save(convertToEntity(dto));
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServcioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoServcioDTO dto) throws Exception {
        dto.setIdTipoServicio(id);
        TipoServicio obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TipoServcioDTO>>  readAll() throws Exception{
        List<TipoServcioDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServcioDTO> readById(@PathVariable("id") Integer id) throws Exception{
        TipoServicio obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private TipoServcioDTO convertToDto(TipoServicio obj){
        return mapper.map(obj, TipoServcioDTO.class);
    }

    private TipoServicio convertToEntity(TipoServcioDTO dto){

        return mapper.map(dto, TipoServicio.class);
    }
}

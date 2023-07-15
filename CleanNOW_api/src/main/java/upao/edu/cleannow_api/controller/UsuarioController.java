package upao.edu.cleannow_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.edu.cleannow_api.dto.ProfesionalDTO;
import upao.edu.cleannow_api.dto.UsuarioDTO;
import upao.edu.cleannow_api.exception.DataAlreadyExistsException;
import upao.edu.cleannow_api.model.Profesional;
import upao.edu.cleannow_api.model.Rol;
import upao.edu.cleannow_api.model.Usuario;
import upao.edu.cleannow_api.model.UsuarioRol;
import upao.edu.cleannow_api.service.IProfesionalService;
import upao.edu.cleannow_api.service.IUsuarioService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {
    private final IUsuarioService service;

    @Qualifier("UsuarioMapper")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        try {
            dto.setPerfil("default.png");
            Set<UsuarioRol> roles = new HashSet<>();

            Rol rol = new Rol();
            rol.setRolId(2L);
            rol.setNombre("NORMAL");

            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(convertToEntity(dto));
            usuarioRol.setRol(rol);
            Usuario obj = service.save(convertToEntity(dto),roles);
            return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
        }catch (DataAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable("id") Integer idUsuario, @RequestBody UsuarioDTO dto) throws Exception {
        dto.setIdUser(idUsuario);
        Usuario obj = service.update(convertToEntity(dto), idUsuario);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>  readAll() throws Exception{
        List<UsuarioDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Usuario obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    /////////////////////convert mapper//////////////////

    private UsuarioDTO convertToDto(Usuario obj){
        return mapper.map(obj, UsuarioDTO.class);
    }

    private Usuario convertToEntity(UsuarioDTO dto){

        return mapper.map(dto, Usuario.class);
    }
}

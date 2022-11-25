package com.ReservasApi.springReservas.ControllerModule;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ReservasApi.springReservas.DTOmodule.ReservaDTO;
import com.ReservasApi.springReservas.DominioModule.Reserva;
import com.ReservasApi.springReservas.ServiceModule.ReservaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Integer id){
        Reserva obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {

        List<Reserva> listaEquipamento = service.findAll();
        List<ReservaDTO> listaEquipamentoDTO = listaEquipamento.stream().map(obj -> new ReservaDTO(obj))
                .collect(Collectors.toList());
                
        return ResponseEntity.ok().body(listaEquipamentoDTO);
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@Valid @RequestBody Reserva obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> update(@Valid @PathVariable Integer id, @RequestBody ReservaDTO objDTO) {
        Reserva newObj = service.update(id, objDTO);

        return ResponseEntity.ok().body(new ReservaDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.ReservasApi.springReservas.ServiceModule;

import java.util.List;
import java.util.Optional;

import com.ReservasApi.springReservas.DTOmodule.ReservaDTO;
import com.ReservasApi.springReservas.DominioModule.Reserva;
import com.ReservasApi.springReservas.ExceptionsModule.DataIntegrityViolation;
import com.ReservasApi.springReservas.ExceptionsModule.ObjectNotFoundException;
import com.ReservasApi.springReservas.RepositoryModule.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository repository;

    public Reserva findById(Integer id) {
        Optional<Reserva> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Reserva.class.getName()));
    }

    public List<Reserva> findAll() {
        return repository.findAll();
    }

    public Reserva create (Reserva obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Reserva update(Integer id, ReservaDTO objDTO){

        Reserva obj = findById(id);

        obj.setData(objDTO.getData());
        obj.setHoraInicio(objDTO.getHoraInicio());
        obj.setHoraTermino(objDTO.getHoraTermino());

        return repository.save(obj);
    }

    public void delete(Integer id) {
        this.findById(id);
        try {
            repository.deleteById(id); 
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolation("Equipamento não pôde ser deletado!");
        }
    }
}

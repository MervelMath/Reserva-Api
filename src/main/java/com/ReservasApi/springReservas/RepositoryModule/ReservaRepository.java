package com.ReservasApi.springReservas.RepositoryModule;

import com.ReservasApi.springReservas.DominioModule.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
    
}

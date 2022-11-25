package com.ReservasApi.springReservas.ServiceModule;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservasApi.springReservas.DominioModule.Reserva;
import com.ReservasApi.springReservas.RepositoryModule.ReservaRepository;

@Service
public class DBService {

        @Autowired
        private ReservaRepository reservaRepository;

        
        public void InstanciaBaseDeDados() {

                Reserva reserva = new Reserva(1, "10/10/2022", "10:30", "10:40");
                
                this.reservaRepository.saveAll(Arrays.asList(reserva));
        }
}

package com.example.hotel.service;

import com.example.hotel.model.Reserva;
import com.example.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    // Obtener una reserva por ID
    public Optional<Reserva> obtenerReservaPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    // Registrar una nueva reserva
    public Reserva registrarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Actualizar una reserva existente
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada) {
        if (reservaRepository.existsById(id)) {
            reservaActualizada.setId(id);
            return reservaRepository.save(reservaActualizada);
        }
        return null; // Si no existe, devolvemos null
    }

    // Eliminar una reserva
    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}

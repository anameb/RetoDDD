package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.EventChange;

import co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import co.com.sofkau.hotel.reserva.events.MedioDePagoModificado;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.events.TelefonoHuespedCambiado;
import co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;


import java.util.Set;

public class ReservaEventChange extends EventChange {
    public ReservaEventChange(Reserva reserva) {
        apply((ReservaCreada event) -> {
            reserva.fechaIngreso = event.getFechaIngreso();
            reserva.fecha = event.getFecha();
        });

        apply((MedioDePagoModificado event ) -> {
            var pagoId = event.getPagoId();
            var pago = new MedioDePago();
            reserva.pago.modificarMedioDePago(pago);

        });

       apply((HabitacionAgregada event) -> {
           var habitacionId = event.getHabitacionId();
           var habitacion = new Habitacion(habitacionId, event.getDescripcion(), event.getTotal());
           reserva.habitacion =habitacion ;
       });

       apply((TelefonoHuespedCambiado event) -> {
           var telefono = event.getTelefono();
           reserva.huesped.cambiarTelefono(telefono);

       });

    }
}

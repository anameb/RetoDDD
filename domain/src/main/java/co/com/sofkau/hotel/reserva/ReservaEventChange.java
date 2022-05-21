package domain.src.main.java.co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.EventChange;
import domain.src.main.java.co.com.sofkau.hotel.administracion.Externo;
import domain.src.main.java.co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;
import domain.src.main.java.co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import domain.src.main.java.co.com.sofkau.hotel.reserva.events.MedioDePagoModificado;
import domain.src.main.java.co.com.sofkau.hotel.reserva.events.ReservaCreada;
import domain.src.main.java.co.com.sofkau.hotel.reserva.events.TelefonoHuespedCambiado;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import domain.src.main.java.co.com.sofkau.hotel.values.Descripcion;

import java.util.Set;

public class ReservaEventChange extends EventChange {
    public ReservaEventChange(Reserva reserva) {
        apply((ReservaCreada event) -> {
            reserva.fechaIngreso = event.getFechaIngreso();
            reserva.fecha = event.getFecha();
            reserva.pago = event.getPago();
            reserva.huesped = event.getHuesped();
            reserva.habitacion = event.getHabitacion();
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

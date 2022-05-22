package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.EventChange;

import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.reserva.events.HabitacionAgregada;
import co.com.sofkau.hotel.reserva.events.MedioDePagoModificado;
import co.com.sofkau.hotel.reserva.events.ReservaCreada;
import co.com.sofkau.hotel.reserva.events.TelefonoHuespedCambiado;
import co.com.sofkau.hotel.reserva.valuesReserva.HuespedId;
import co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;


import java.util.Set;

public class ReservaEventChange extends EventChange {
   HuespedId entityId = new HuespedId("2345");
   PagoId entityIdPago = new PagoId("4558");
    public ReservaEventChange(Reserva reserva) {
        apply((ReservaCreada event) -> {
            reserva.fechaIngreso = event.getFechaIngreso();
            reserva.fecha = event.getFecha();
            reserva.huesped= new Huesped(entityId);
            reserva.pago= new Pago(entityIdPago);
        });

        apply((MedioDePagoModificado event ) -> {
            var pagoId = event.getMedioDePago();
            reserva.pago.modificarMedioDePago(pagoId);

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

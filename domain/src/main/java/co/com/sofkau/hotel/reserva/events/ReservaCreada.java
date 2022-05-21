package co.com.sofkau.hotel.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;

public class ReservaCreada extends DomainEvent {

    private final FechaIngreso fechaIngreso;
    private final Fecha fecha;

    public ReservaCreada(FechaIngreso fechaIngreso, Fecha fecha) {
        super("co.com.sofkau.hotel.reserva.events.ReservaCreada");
        this.fechaIngreso = fechaIngreso;
        this.fecha = fecha;
    }

    public FechaIngreso getFechaIngreso() {
        return fechaIngreso;
    }

    public Fecha getFecha() {
        return fecha;
    }

}

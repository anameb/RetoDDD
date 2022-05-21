package co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.*;
import co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;

public class CrearReserva  extends Command {

    private final ReservaId reservaId;
    private final FechaIngreso fechaIngreso;
    private final Fecha fecha;

    public CrearReserva(ReservaId reservaId, FechaIngreso fechaIngreso, Fecha fecha) {
        this.reservaId = reservaId;
        this.fechaIngreso = fechaIngreso;
        this.fecha = fecha;

    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public FechaIngreso getFechaIngreso() {
        return fechaIngreso;
    }

    public Fecha getFecha() {
        return fecha;
    }

}

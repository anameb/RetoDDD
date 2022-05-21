package domain.src.main.java.co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.*;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Habitacion;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Huesped;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Pago;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;

public class CrearReserva  extends Command {

    private final ReservaId reservaId;
    private final FechaIngreso fechaIngreso;
    private final Fecha fecha;

    private final Pago pago;

    private final Huesped huesped;

    private final Habitacion habitacion;



    public CrearReserva(ReservaId reservaId, FechaIngreso fechaIngreso, Fecha fecha, Pago pago, Huesped huesped, Habitacion habitacion) {
        this.reservaId = reservaId;
        this.fechaIngreso = fechaIngreso;
        this.fecha = fecha;
        this.pago = pago;
        this.huesped = huesped;
        this.habitacion = habitacion;
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

    public Pago getPago() {
        return pago;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
}

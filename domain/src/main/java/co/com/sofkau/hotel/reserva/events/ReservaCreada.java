package domain.src.main.java.co.com.sofkau.hotel.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Habitacion;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Huesped;
import domain.src.main.java.co.com.sofkau.hotel.reserva.Pago;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.Fecha;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.FechaIngreso;

public class ReservaCreada extends DomainEvent {

    private final FechaIngreso fechaIngreso;
    private final Fecha fecha;

    private final Pago pago;

    private final Huesped huesped;

    private final Habitacion habitacion;

    public ReservaCreada(FechaIngreso fechaIngreso, Fecha fecha, Pago pago, Huesped huesped, Habitacion habitacion) {
        super("co.com.sofkau.hotel.reserva.events.ReservaCreada");
        this.fechaIngreso = fechaIngreso;
        this.fecha = fecha;
        this.pago = pago;
        this.huesped = huesped;
        this.habitacion = habitacion;
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

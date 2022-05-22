package co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Total;

public class AgragarHabitacion extends Command {

    private final ReservaId reservaId;
    private final Descripcion descripcion;
    private final Total total;

    private final HabitacionId habitacionId;

    public AgragarHabitacion(ReservaId reservaId, Descripcion descripcion, Total total, HabitacionId habitacionId) {
        this.reservaId = reservaId;
        this.descripcion = descripcion;
        this.total = total;
        this.habitacionId = habitacionId;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Total getTotal() {
        return total;
    }

    public HabitacionId getHabitacionId() {
        return habitacionId;
    }
}

package co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Total;

public class AgragarHabitacion extends Command {

    private final ReservaId reservaId;
    private final Descripcion descripcion;
    private final Total total;

    public AgragarHabitacion(ReservaId reservaId, Descripcion descripcion, Total total) {
        this.reservaId = reservaId;
        this.descripcion = descripcion;
        this.total = total;
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
}

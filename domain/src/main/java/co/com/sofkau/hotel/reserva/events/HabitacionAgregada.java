package domain.src.main.java.co.com.sofkau.hotel.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import domain.src.main.java.co.com.sofkau.hotel.values.Descripcion;
import domain.src.main.java.co.com.sofkau.hotel.values.Total;

public class HabitacionAgregada extends DomainEvent {

    private final HabitacionId habitacionId;
    private final Descripcion descripcion;
    private final Total total;

    public HabitacionAgregada(HabitacionId habitacionId, Descripcion descripcion, Total total) {
        super("co.com.sofkau.hotel.reserva.events.HabitacionAgregada");
        this.habitacionId = habitacionId;
        this.descripcion = descripcion;
        this.total = total;

    }

    public HabitacionId getHabitacionId() {
        return habitacionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Total getTotal() {
        return total;
    }
}

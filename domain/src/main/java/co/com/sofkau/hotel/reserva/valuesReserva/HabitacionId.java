package co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.Identity;

public class HabitacionId extends Identity {
    public HabitacionId(String id) { super(id);}

    public static HabitacionId of(String id) {

        return new HabitacionId(id);
    }

    public HabitacionId() {
    }
}

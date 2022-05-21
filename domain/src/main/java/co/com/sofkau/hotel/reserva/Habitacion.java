package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import co.com.sofkau.hotel.values.Total;

public class Habitacion extends Entity<HabitacionId> {
    protected Descripcion descripcion;
    protected Total total;
    private Habitacion habitacion;

    public Habitacion(HabitacionId habitacionId, Descripcion descripcion, Total total) {
        super(habitacionId);
        this.descripcion = descripcion;
        this.total = total;
    }

    public void agregarHabitacion(Habitacion habitacion){

        this.habitacion = habitacion;
    }

}

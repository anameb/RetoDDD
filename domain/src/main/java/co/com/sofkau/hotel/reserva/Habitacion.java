package domain.src.main.java.co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.src.main.java.co.com.sofkau.hotel.values.Descripcion;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.HabitacionId;
import domain.src.main.java.co.com.sofkau.hotel.values.Total;

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

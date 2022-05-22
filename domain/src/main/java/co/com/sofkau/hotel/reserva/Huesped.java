package co.com.sofkau.hotel.reserva;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.reserva.valuesReserva.HuespedId;
import co.com.sofkau.hotel.values.Nombre;
import co.com.sofkau.hotel.values.Telefono;

public class Huesped extends Entity<HuespedId> {

    protected Nombre nombre;
    protected Telefono telefono;

    public Huesped(HuespedId huespedId, Nombre nombre, Telefono telefono) {
        super(huespedId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarTelefono(Telefono telefono){

        this.telefono = telefono;
    }

    public Huesped(HuespedId entityId) {
        super(entityId);
    }
}

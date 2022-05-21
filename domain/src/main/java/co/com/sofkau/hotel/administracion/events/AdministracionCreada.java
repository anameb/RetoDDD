package co.com.sofkau.hotel.administracion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.values.Telefono;

public class AdministracionCreada extends DomainEvent{

    private final Telefono telefono;

    public AdministracionCreada(Telefono telefono) {
        super("co.com.sofkau.hotel.administracion.events.AdministracionCreada");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

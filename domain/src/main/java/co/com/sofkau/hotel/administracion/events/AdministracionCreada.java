package co.com.sofkau.hotel.administracion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.values.Telefono;

public class AdministracionCreada extends DomainEvent{
    private final AdministracionId administracionId;
    private final Telefono telefono;

    public AdministracionCreada(AdministracionId administracionId, Telefono telefono) {
        super("co.com.sofkau.hotel.administracion.events.AdministracionCreada");
        this.administracionId = administracionId;
        this.telefono = telefono;
    }

    public AdministracionId getAdministracionId() {
        return administracionId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

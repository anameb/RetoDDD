package co.com.sofkau.hotel.administracion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.values.Telefono;


public class TelefonoEmpleadoCambiado extends DomainEvent {
    private final EmpleadoId empleadoId;
    
    private final Telefono telefono;


    public TelefonoEmpleadoCambiado(EmpleadoId empleadoId, Telefono telefono) {
        super("co.com.sofkau.hotel.TelefonoEmpleadoCreado");
        this.empleadoId = empleadoId;
        this.telefono = telefono;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

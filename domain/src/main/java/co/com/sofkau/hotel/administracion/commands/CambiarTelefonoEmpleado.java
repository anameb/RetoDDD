package co.com.sofkau.hotel.administracion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.EmpleadoId;
import co.com.sofkau.hotel.values.Telefono;


public class CambiarTelefonoEmpleado extends Command {
        private final EmpleadoId empleadoId;
        private final Telefono telefono;

        private final AdministracionId administracionId;

    public CambiarTelefonoEmpleado(EmpleadoId empleadoId, Telefono telefono, AdministracionId administracionId) {
        this.empleadoId = empleadoId;
        this.telefono = telefono;
        this.administracionId = administracionId;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public AdministracionId getAdministracionId() {
        return administracionId;
    }
}




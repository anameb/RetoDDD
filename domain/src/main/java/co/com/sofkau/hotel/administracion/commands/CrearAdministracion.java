package co.com.sofkau.hotel.administracion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import domain.src.main.java.co.com.sofkau.hotel.values.Telefono;

public class CrearAdministracion extends Command {

    private final AdministracionId administracionId;

    private final Telefono telefono;


    public CrearAdministracion(AdministracionId administracionId, Telefono telefono) {
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

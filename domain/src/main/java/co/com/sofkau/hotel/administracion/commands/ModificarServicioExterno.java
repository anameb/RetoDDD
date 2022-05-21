package co.com.sofkau.hotel.administracion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.administracion.valuesAdmi.AdministracionId;
import co.com.sofkau.hotel.administracion.valuesAdmi.ExternoId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;

public class ModificarServicioExterno extends Command {

    private final AdministracionId administracionId;
    private final ExternoId externoId;
    private final Servicio servicio;


    public ModificarServicioExterno(ExternoId externoId, Servicio servicio, AdministracionId administracionId) {
        this.administracionId = administracionId;
        this.externoId = externoId;
        this.servicio = servicio;
    }

    public AdministracionId getAdministracionId() {
        return administracionId;
    }

    public ExternoId getExternoId() {
        return externoId;
    }

    public Servicio getServicio() {
        return servicio;
    }
}

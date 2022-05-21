package co.com.sofkau.hotel.administracion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.administracion.valuesAdmi.ExternoId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;

public class ServicioExternoModificado extends DomainEvent {

    private final ExternoId externoId;
    private final Servicio servicio;

    public ServicioExternoModificado(ExternoId externoId, Servicio servicio) {
        super("co.com.sofkau.hotel.ServicioExternoModificado");
        this.externoId = externoId;
        this.servicio = servicio;
    }

    public ExternoId getExternoId() {
        return externoId;
    }

    public Servicio getServicio() {
        return servicio;
    }
}

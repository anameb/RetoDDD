package co.com.sofkau.hotel.administracion;



import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.administracion.valuesAdmi.ExternoId;
import co.com.sofkau.hotel.administracion.valuesAdmi.Servicio;

import java.util.Set;

public class Externo extends Entity<ExternoId> {

    protected Set<Servicio> servicios;

    public Externo(ExternoId entityId, Set<Servicio> servicios) {
        super(entityId);
        this.servicios = servicios;
    }

    public void modificarServicio(Servicio servicio){

        this.servicios = servicios;
    }
}

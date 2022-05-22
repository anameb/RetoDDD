package co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

public class CocinaCreada extends DomainEvent {

    private final CocinaId cocinaId;

    private final Tipo tipo;

    public CocinaCreada(CocinaId cocinaId, Tipo tipo) {
        super("co.com.sofkau.hotel.cocina.events.CocinaCreada");
        this.cocinaId = cocinaId;
        this.tipo = tipo;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }

    public Tipo getTipo() {
        return tipo;
    }



}

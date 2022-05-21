package co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

public class CocinaCreada extends DomainEvent {

    private final Tipo tipo;

    public CocinaCreada(Tipo tipo) {
        super("co.com.sofkau.hotel.cocina.events.CocinaCreada");
        this.tipo = tipo;
    }
    public Tipo getTipo() {
        return tipo;
    }

}

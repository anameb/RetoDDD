package co.com.sofkau.hotel.cocina.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.cocina.Calificacion;
import co.com.sofkau.hotel.cocina.Menu;
import co.com.sofkau.hotel.cocina.Pedido;
import co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

public class CrearCocina extends Command {

    private final CocinaId cocinaId;

    private final Tipo tipo;

    public CrearCocina(CocinaId cocinaId, Tipo tipo) {
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




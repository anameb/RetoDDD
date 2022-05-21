package domain.src.main.java.co.com.sofkau.hotel.cocina.commands;

import co.com.sofka.domain.generic.Command;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Calificacion;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Menu;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Pedido;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

public class CrearCocina extends Command {

    private final CocinaId cocinaId;

    private final Tipo tipo;

    private final Menu menu;

    private final  Pedido pedido;

    private final Calificacion calificacion;

    public CrearCocina(CocinaId cocinaId, Tipo tipo, Menu menu, Pedido pedido, Calificacion calificacion) {
        this.cocinaId = cocinaId;
        this.tipo = tipo;
        this.menu = menu;
        this.pedido = pedido;
        this.calificacion = calificacion;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Menu getMenu() {
        return menu;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}

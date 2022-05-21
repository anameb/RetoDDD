package domain.src.main.java.co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Calificacion;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Menu;
import domain.src.main.java.co.com.sofkau.hotel.cocina.Pedido;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Tipo;

public class CocinaCreada extends DomainEvent {

    private final Tipo tipo;

    private final Menu menu;

    private final Pedido pedido;

    private final Calificacion calificacion;


    public CocinaCreada(Tipo tipo, Menu menu, Pedido pedido, Calificacion calificacion) {
        super("co.com.sofkau.hotel.cocina.events.CocinaCreada");
        this.tipo = tipo;
        this.menu = menu;
        this.pedido = pedido;
        this.calificacion = calificacion;
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

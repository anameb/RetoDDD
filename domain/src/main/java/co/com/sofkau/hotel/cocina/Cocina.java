package co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import co.com.sofkau.hotel.cocina.events.MenuAgregado;
import co.com.sofkau.hotel.cocina.valuesCocina.*;
import co.com.sofkau.hotel.values.Descripcion;
import co.com.sofkau.hotel.values.Nombre;

import java.util.List;


public class Cocina extends AggregateEvent<CocinaId> {

    protected Tipo tipo;

    protected Menu menu;

    protected Pedido pedido;

    protected Calificacion calificacion;


    public Cocina(CocinaId cocinaId, Tipo tipo) {
        super(cocinaId);
        appendChange(new CocinaCreada(cocinaId, tipo)).apply();
        subscribe(new CocinaEventChange(this));
    }

    private Cocina(CocinaId cocinaId) {
        super(cocinaId);
        subscribe(new CocinaEventChange(this));
    }

    public static Cocina from(CocinaId cocinaId, List<DomainEvent> events){
        var cocina = new Cocina(cocinaId);
        events.forEach(cocina::applyEvent);
        return cocina;
    }

    public void AgregarMenu(Nombre nombre, Descripcion descripcion) {
        var menuId = new MenuId();
        appendChange(new MenuAgregado(menuId, nombre,descripcion)).apply();
    }

    public void ModificarCantidadDePedido(PedidoId pedidoId, Cantidad cantidad){
        appendChange(new CantidadPedidoModificada(pedidoId,cantidad)).apply();

    }
    public void AlmacenarComentario(CalificacionId calificacionId,Comentario comentario){
        appendChange(new ComentarioAlmacenado(calificacionId, comentario)).apply();
    }



}

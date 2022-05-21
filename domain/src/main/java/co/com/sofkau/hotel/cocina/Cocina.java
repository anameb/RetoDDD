package domain.src.main.java.co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.CocinaCreada;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.MenuAgregado;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.*;
import domain.src.main.java.co.com.sofkau.hotel.values.Descripcion;
import domain.src.main.java.co.com.sofkau.hotel.values.Nombre;


public class Cocina extends AggregateEvent<CocinaId> {

    protected Tipo tipo;

    protected Menu menu;

    protected Pedido pedido;

    protected Calificacion calificacion;


    public Cocina(CocinaId cocinaId, Tipo tipo, Menu menu, Pedido pedido, Calificacion calificacion) {
        super(cocinaId);
        appendChange(new CocinaCreada(tipo,menu, pedido, calificacion)).apply();
        subscribe(new CocinaEventChange(this));
    }

    private Cocina(CocinaId cocinaId) {
        super(cocinaId);
        subscribe(new CocinaEventChange(this));
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

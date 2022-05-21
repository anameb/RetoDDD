package co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import co.com.sofkau.hotel.cocina.events.MenuAgregado;
import co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import co.com.sofkau.hotel.cocina.valuesCocina.Comentario;


public class CocinaEventChange extends EventChange {
    public CocinaEventChange(Cocina cocina) {
        apply((CocinaCreada event ) -> {
            cocina.tipo = event.getTipo();
        });
        apply((MenuAgregado event) -> {
            var menuId = event.getMenuId();
            var menu = new Menu(menuId, event.getNombre(),event.getDescripcion());
            cocina.menu =menu ;
        });

        apply((CantidadPedidoModificada event ) -> {
            var pedidoId = event.getPedidoId();
            var pedido = new Cantidad();
            cocina.pedido.modificarCantidad(pedido);

        });
        apply((ComentarioAlmacenado event) -> {
            cocina.calificacion.almacenarComentario(event.getComentario());
        });


    }
}

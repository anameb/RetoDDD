package domain.src.main.java.co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.EventChange;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.CocinaCreada;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import domain.src.main.java.co.com.sofkau.hotel.cocina.events.MenuAgregado;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Comentario;


public class CocinaEventChange extends EventChange {
    public CocinaEventChange(Cocina cocina) {
        apply((CocinaCreada event ) -> {
            cocina.tipo = event.getTipo();
            cocina.pedido = event.getPedido();
            cocina.menu = event.getMenu();
            cocina.calificacion = event.getCalificacion();
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

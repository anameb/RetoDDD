package co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada;
import co.com.sofkau.hotel.cocina.events.CocinaCreada;
import co.com.sofkau.hotel.cocina.events.ComentarioAlmacenado;
import co.com.sofkau.hotel.cocina.events.MenuAgregado;
import co.com.sofkau.hotel.cocina.valuesCocina.CalificacionId;
import co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import co.com.sofkau.hotel.cocina.valuesCocina.Comentario;
import co.com.sofkau.hotel.cocina.valuesCocina.PedidoId;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;


public class CocinaEventChange extends EventChange {

    PedidoId entityIdPedido = new PedidoId("4558");
    CalificacionId entityIdCali = new CalificacionId("1234");
    public CocinaEventChange(Cocina cocina) {
        apply((CocinaCreada event ) -> {
            cocina.tipo = event.getTipo();
            cocina.pedido = new Pedido(entityIdPedido);
            cocina.calificacion = new Calificacion(entityIdCali);
        });
        apply((MenuAgregado event) -> {
            var menuId = event.getMenuId();
            var menu = new Menu(menuId, event.getNombre(),event.getDescripcion());
            cocina.menu =menu ;
        });

        apply((CantidadPedidoModificada event ) -> {
            var pedidoId = event.getCantidad();
            cocina.pedido.modificarCantidad(pedidoId);

        });
        apply((ComentarioAlmacenado event) -> {
            cocina.calificacion.almacenarComentario(event.getComentario());
        });


    }
}

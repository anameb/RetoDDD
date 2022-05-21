package co.com.sofkau.hotel.cocina.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import co.com.sofkau.hotel.cocina.valuesCocina.PedidoId;

public class CantidadPedidoModificada extends DomainEvent {
    private final PedidoId pedidoId;

    private final Cantidad cantidad;


    public CantidadPedidoModificada(PedidoId pedidoId, Cantidad cantidad) {
        super("co.com.sofkau.hotel.cocina.events.CantidadPedidoModificada");
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}

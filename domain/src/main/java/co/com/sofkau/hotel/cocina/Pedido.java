package co.com.sofkau.hotel.cocina;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import co.com.sofkau.hotel.cocina.valuesCocina.PedidoId;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;

public class Pedido  extends Entity<PedidoId> {
    protected Cantidad cantidad;

    public Pedido(PedidoId pedidoId, Cantidad cantidad) {
        super(pedidoId);
        this.cantidad = cantidad;
    }

    public void modificarCantidad(Cantidad cantidad){
        this.cantidad= cantidad;
    }
    public Pedido(PedidoId entityId) {
        super(entityId);
    }
}

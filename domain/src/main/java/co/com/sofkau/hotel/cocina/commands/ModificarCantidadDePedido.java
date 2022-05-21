package domain.src.main.java.co.com.sofkau.hotel.cocina.commands;

import co.com.sofka.domain.generic.Command;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.Cantidad;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.CocinaId;
import domain.src.main.java.co.com.sofkau.hotel.cocina.valuesCocina.PedidoId;

public class ModificarCantidadDePedido extends Command {

    private final PedidoId pedidoId;

    private final Cantidad cantidad;

    private final CocinaId cocinaId;

    public ModificarCantidadDePedido(PedidoId pedidoId, Cantidad cantidad, CocinaId cocinaId) {
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
        this.cocinaId = cocinaId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public CocinaId getCocinaId() {
        return cocinaId;
    }
}

package co.com.sofkau.hotel.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.reserva.valuesReserva.HuespedId;
import co.com.sofkau.hotel.values.Telefono;

import java.util.UUID;

public class TelefonoHuespedCambiado extends DomainEvent {
    private final HuespedId huespedId;

    private final Telefono telefono;

    public TelefonoHuespedCambiado(HuespedId huespedId, Telefono telefono) {
        super("co.com.sofkau.hotel.reserva.events.TelefonoHuespedCambiado");
        this.huespedId = huespedId;
        this.telefono = telefono;
    }

    public HuespedId getHuespedId() {
        return huespedId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

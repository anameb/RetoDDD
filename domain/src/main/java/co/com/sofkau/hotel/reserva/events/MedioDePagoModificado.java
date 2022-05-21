package co.com.sofkau.hotel.reserva.events;


import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;

import java.util.UUID;

public class MedioDePagoModificado extends DomainEvent {

    private final PagoId pagoId;
    private final MedioDePago medioDePago;

    public MedioDePagoModificado(PagoId pagoId, MedioDePago medioDePago) {
        super("co.com.sofkau.hotel.reserva.events.MedioDePAgoModificado");
        this.pagoId = pagoId;
        this.medioDePago = medioDePago;
    }

    public PagoId getPagoId() {
        return pagoId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
}

package co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.hotel.reserva.valuesReserva.MedioDePago;
import co.com.sofkau.hotel.reserva.valuesReserva.PagoId;
import co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;

public class ModificarMedioDePago extends Command {
    private final PagoId pagoId;
    private final MedioDePago medioDePago;
    private final ReservaId reservaId;

    public ModificarMedioDePago(PagoId pagoId, MedioDePago medioDePago, ReservaId reservaId) {
        this.pagoId = pagoId;
        this.medioDePago = medioDePago;
        this.reservaId = reservaId;
    }

    public PagoId getPagoId() {
        return pagoId;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }
}

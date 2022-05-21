package co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.Identity;

public class PagoId extends Identity {
    public PagoId(String id){
        super(id);
    }

    public PagoId() {
    }

    public static PagoId of(String id) {

        return new PagoId(id);
    }
}

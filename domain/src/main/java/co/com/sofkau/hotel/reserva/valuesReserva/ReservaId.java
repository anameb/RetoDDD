package co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.Identity;


public class ReservaId extends Identity {
    public ReservaId(String id) { super(id);}

    public static ReservaId of(String id) {

        return new ReservaId(id);
    }

}


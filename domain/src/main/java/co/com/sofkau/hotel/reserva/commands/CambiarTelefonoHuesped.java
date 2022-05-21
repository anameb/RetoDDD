package domain.src.main.java.co.com.sofkau.hotel.reserva.commands;

import co.com.sofka.domain.generic.Command;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.HuespedId;
import domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva.ReservaId;
import domain.src.main.java.co.com.sofkau.hotel.values.Telefono;

public class CambiarTelefonoHuesped extends Command {

    private final HuespedId huespedId;
    private final Telefono telefono;
    private final ReservaId reservaId;

    public CambiarTelefonoHuesped(HuespedId huespedId, Telefono telefono, ReservaId reservaId) {
        this.huespedId = huespedId;
        this.telefono = telefono;
        this.reservaId = reservaId;
    }

    public HuespedId getHuespedId() {
        return huespedId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }
}

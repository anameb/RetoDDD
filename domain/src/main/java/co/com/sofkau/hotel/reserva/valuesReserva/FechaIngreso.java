package domain.src.main.java.co.com.sofkau.hotel.reserva.valuesReserva;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class FechaIngreso implements ValueObject<Fecha.Pros> {
    private final LocalDateTime hora;
    private final LocalDate dia;

    public FechaIngreso(LocalDateTime hora, LocalDate dia) {
        //TODO: agregar validaciones (fechas funturas, el dia debe ser de 24)
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }

    @Override
    public Fecha.Pros value() {
        return new Fecha.Pros () {
            @Override
            public LocalDateTime hora() {
                return hora;
            }

            @Override
            public LocalDate dia() {
                return dia;
            }
        };
    }

    public interface Pros {
        LocalDateTime hora();
        LocalDate dia();
    }
}

